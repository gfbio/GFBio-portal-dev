<!DOCTYPE html>
 
<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	<!--<link href="//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic" rel="stylesheet" type="text/css">-->
	<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic|Open+Sans+Condensed:300,300italic,700|Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic" rel="stylesheet" type="text/css">
	
</head>


<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

  <div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
		
		<div class="container">
			<a href="http://www.gfbio.org">
                <h1 class="navbar-brand"></h1>
			</a>
			
			<div class="navsignin">
				<#if !is_signed_in>
					<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
				</#if>
			</div>
			
			
			<div id="nav">
				<#if has_navigation>
						<#include "${full_templates_path}/navigation.ftl" />
				</#if>	
			</div>
			
			
		</div>
	</header>

	<section id="content">
		<h1 class="hide-accessible">${the_title}</h1>

		<nav id="breadcrumbs">
			<@liferay.breadcrumbs />
		</nav>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- inject:js -->
<!-- endinject -->

</body>

</html>