<?xml version="1.0" encoding="UTF-8"?>
<!-- ��XMLΪ StackedLineChart ����״���ۼӣ����������ͼ���ڵ����ݿ�����Ҫ�ڱ��������� --> 
<root>  
<#list nodes as node>
  <node>
  <months>${node.xaxis}</months>
  <data1>${node.columnar1}</data1>
  <data2>${node.columnar2}</data2>
  <data3>${node.columnar3}</data3>
  <data4>${node.columnar4}</data4>
  <data5>${node.line}</data5>
  </node>
 </#list>
 </root>