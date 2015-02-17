create table gfbio_Project (
	projectID LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table gfbio_tab_ResearchObject (
	ro_ID LONG not null primary key,
	ro_name VARCHAR(75) null,
	ro_meta VARCHAR(75) null
);