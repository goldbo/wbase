<?xml version="1.0" encoding="UTF-8"?>
<!-- ��XMLΪ StackedLineChart ����״���ۼӣ����������ͼ���ڵ����ݿ�����Ҫ�ڱ��������� --> 
<root>  
<#list nodes as node>
  <node>
  <months>${node.xaxis}</months>
  <data1>${node.columnar}</data1>
  <data2>${node.line}</data2>
  </node>
 </#list>
 </root>