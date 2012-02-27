<?xml version="1.0" encoding="UTF-8"?>
<!-- 该XML为 StackedLineChart 即柱状（累加）与折线组合图，节点数据控制需要在报表中设置 --> 
<root>  
<#list nodes as node>
  <node>
  <months>${node.xaxis}</months>
  <data1>${node.columnar}</data1>
  <data2>${node.line}</data2>
  </node>
 </#list>
 </root>