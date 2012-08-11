<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<title>DMS | <t:getAsString name="title" ignore="true" /></title>

<link href="<s:url value="/assets" />/css/styles.css"
	rel="stylesheet" type="text/css" />

</head>

<body>
	<div id="container">
		<div id="header">
			<t:insertAttribute name="top" />
			<!--<co id="co_tile_top" />-->
		</div>
		<div id="topTabs"><t:insertAttribute name="topTabs"/></div>
		<div class="content-container">
			<div class="side">
				<t:insertAttribute name="side" />
				<!--<co id="co_tile_side" />-->
			</div>
			<div class="content">
				<t:insertAttribute name="content" />
				<!--<co id="co_tile_content" />-->
			</div>
		</div>
		<div class="page-footer">
			<t:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>
