<?xml version="1.0" encoding="UTF-8"?>
<!-- ��XMLΪ StackedLineChart ����״���ۼӣ����������ͼ���ڵ����ݿ�����Ҫ�ڱ��������� --> 
<root>  
<#list nodes as node>
  <node>
  <days>${node.xaxis}</days>
  <data1>${node.line1}</data1>
  <data2>${node.line2}</data2>
  <data3>${node.line3}</data3>
  </node>
 </#list>
 </root>