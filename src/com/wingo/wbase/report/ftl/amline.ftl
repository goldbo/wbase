<?xml version="1.0" encoding="UTF-8"?>
<chart>
  <!--
  <message>
    <![CDATA[You can broadcast any message to chart from data XML file]]>
  </message>
  -->
	<series>
		<#list series as x>
			<value xid="${x_index}">${x}</value>
		</#list>
	</series>
	<graphs>
		<#list graphs as g>
		<graph gid="${g_index}">
			<#list g.graphValues as gv>
			<value xid="${gv_index}">${gv}</value>
			</#list>
		</graph>
		</#list>
	</graphs>
</chart>
