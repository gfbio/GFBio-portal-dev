ALTER TABLE gfbio_basket ADD COLUMN queryKeyword text;
ALTER TABLE gfbio_basket ADD COLUMN queryFilter text;


--select queryjson from gfbio_basket where querykeyword is null
update gfbio_basket set querykeyword = '' where queryjson like '%{"match_all":{}%'

update gfbio_basket set querykeyword = subquery.b from (
SELECT queryjson, SUBSTRING(a,1,position('","' in a)-1)b 
from (SELECT queryjson, SUBSTRING(queryjson, position('"simple_query_string":{"query":"'in queryjson)+32)a 
from gfbio_basket where not (queryjson like '%{"match_all":{}%')) as sq where not (queryjson like '%{"match_all":{}%'))
as subquery where not (gfbio_basket.queryjson like '%{"match_all":{}%') and gfbio_basket.queryjson=subquery.queryjson

update gfbio_basket set queryfilter = subquery.b from (
SELECT queryjson,queryfilter, SUBSTRING(a,1,position(']' in a))b 
from (SELECT queryjson,queryfilter, SUBSTRING(queryjson, position('"filter":['in queryjson)+9)a 
from gfbio_basket where (queryjson like '%"filter":[%')) as sq where (queryjson like '%"filter":[%'))
as subquery where (gfbio_basket.queryjson like '%"filter":[%') and gfbio_basket.queryjson=subquery.queryjson

--handle old queries--
update gfbio_basket set queryfilter = subquery.b from (
SELECT queryjson,queryfilter, SUBSTRING(a,1,position(']' in a))b 
from (SELECT queryjson,queryfilter, SUBSTRING(queryjson, position('"filters":['in queryjson)+10)a 
from gfbio_basket where (queryjson like '%"filters":[%')) as sq where (queryjson like '%"filters":[%'))
as subquery where (gfbio_basket.queryjson like '%"filters":[%') and gfbio_basket.queryjson=subquery.queryjson

--fill in the empty filter row
update gfbio_basket set queryfilter = '[]' where queryfilter is null or queryfilter = ''