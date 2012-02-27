var bgColor='#FFCC88';
var editModel_aly=false;
var pageNum_aly='';
var flag=false;

function DrawImage(ImgD,img_width,img_height){
   var image=new Image();
    image.src=ImgD.src;
   if(image.width>0 && image.height>0){
     flag=true;
    if(image.width/image.height>= img_width/img_height){
     if(image.width>img_width){  
      ImgD.width=img_width;
      ImgD.height=(image.height*img_width)/image.width;
      }else{
      ImgD.width=image.width;  
      ImgD.height=image.height;
      }
      //ImgD.alt=image.width+"×"+image.height;
      }
    else{
     if(image.height>img_height){  
      ImgD.height=img_height;
      ImgD.width=(image.width*img_height)/image.height;     
      }else{
      ImgD.width=image.width;  
      ImgD.height=image.height;
      }
      //ImgD.alt=image.width+"×"+image.height;
      }
     }
   /**//*else{
     ImgD.src="";
     ImgD.alt=""
     }*/
}

function next_focus()
{
	if(window.event.keyCode ==13)
	{
		window.event.keyCode=9;
	}
}


function controlFocus(){
		window.event.srcElement.style.backgroundColor=bgColor;
}

function controlBlur(){
		window.event.srcElement.style.backgroundColor="";
}

function mouseovertd (o)
{
	o.style.color='#000000';
	o.style.backgroundColor='#FFCC88';

}
function mouseouttd (o)
{
	o.style.color='#000000';
	o.style.backgroundColor='';

}

function getCheckBoxNum(checkBoxName)
{
    var checkboxArr=document.getElementsByName(checkBoxName);
    var num=0;
    for(var i=0;i<checkboxArr.length;i++)
    {
       if(checkboxArr[i].checked)
       {
           num=num+1;
       }
    }
    return num;
}

function getCheckBoxObj(checkBoxName)
{
    var checkboxArr=document.getElementsByName(checkBoxName);
    var obj=null;
    for(var i=0;i<checkboxArr.length;i++)
    {
       if(checkboxArr[i].checked)
       {
           obj=checkboxArr[i];
           break;
       }
    }
    return obj;
}



function goDispartPage(flag,currPage,formId)
{
	var formObj=document.getElementById(formId)
	if(flag=='go')
	{
		var obj=document.getElementById("currentPage")
		 if(isNaN(obj.value))
    	{
     	  alert(pageNum_aly);
          obj.select();
      	  return;
    	}
		else
		{
			currPage=obj.value
		}
	}
	//var oNewNode = document.createElement("<INPUT TYPE='hidden' NAME='pageMethod' VALUE='"+flag+"'>");
    var oNewNode = document.createElement("input");
    oNewNode.setAttribute("type", "hidden");
    oNewNode.setAttribute("name", "pageMethod");
    oNewNode.setAttribute("value", ""+flag+"");
    
    formObj.appendChild(oNewNode);
	formObj.submit();
}

function submitForm(submitbutton,formId,fevf)
{
   var editModel_alyTemp=editModel_aly;
   editModel_aly=false;
   submitbutton.disabled=true
  if(doValidate(formId,fevf))
  {
    
    
  	var objForm =document.getElementById(formId);
  	var allElement=objForm.elements;
  	for(var i=0;i<allElement.length;i++)
  	{
  		if(allElement[i].disabled)
  		{
  			allElement[i].disabled=false;
  		}
  	}
    objForm.submit();
  }
  else
  {
  	editModel_aly=editModel_alyTemp;
  	submitbutton.disabled=false;
  }
   
  
}



function submitFormQuery(submitbutton,formId)
{
     
    submitbutton.disabled=true
  	var objForm =document.getElementById(formId);
    objForm.submit();
  
}


function buttomOnClick(url,target)
{
 
 if(target=='parent')
   {
    parent.location.href=url
   }else if(target=='self')
   {
      location.href=url
   }
   else if(target=='top')
   {
      top.location.href=url
   }
   else
   {
       document.getElementById(target).location.href=url;
   }
}


function getSelectData(obj,flagDis,flagStr)
{

    var rowid = "";
    for (i=0;i<obj.length;i++){
      if (obj[i].checked){
        rowid = rowid+flagStr+"="+obj[i].value+flagDis;
      }
    }
    return rowid;
}


function checkIsSelect(obj)
{

   var count=0;
    for (i=0;i<obj.length;i++){
      if (obj[i].checked){
        count = count +1;
      }
    }
  if(count >0)
  {
        return true;
  }
   return false;
}

function buttomOnClickList(submitbutton,url,target)
{

 if(target=='parent')
   {
    parent.location.href=url
   }else if(target=='self')
   {
      location.href=url
   }
}

   function createButtonByPower(toolBar)
   {
     
     var cells = document.getElementById(toolBar).rows[0].cells;
  	 for (var i = 1; i < cells.length; i++){
     	 createButton(cells[i]);
     	  cells[i].disabled=false;
  	 }
  }
  
function buttomOnClickAdd(submitbutton,url,target)
{
   submitbutton.disabled=true
   
 if(target=='parent')
   {
    parent.location.href=url
   }else if(target=='self')
   {
      location.href=url
   }
   else if(target=='top')
   {
      location.href=url
   }
   else
   {
       document.getElementById(target).location.href=url;
   }
}



function changeEditModel()
{
  editModel_aly=true
}

function initFormGetFocus(controlId)
{
	document.getElementById(controlId).focus();
}

function selectAllGrid(obj,name)
{
	var arrObj=document.getElementsByName(name);
	if(arrObj!=null&&arrObj.length>0)
	{
		for(var i=0;i<arrObj.length;i++)
		   arrObj[i].checked=obj.checked
	}
}

function clearAllSelect(obj,all)
{
    var isSelect=false;
	var arrObj=document.getElementsByName(obj.name);
	if(arrObj!=null&&arrObj.length>0)
	{
		for(var i=0;i<arrObj.length;i++)
		{
		   if(arrObj[i].checked)
		   {
		       isSelect=true;
		       break;
		   }
		}
	}
	document.getElementById(all).checked=isSelect;
}

function onDispartPageChange(formId) {
    var formObj=document.getElementById(formId)
	var oNewNode = document.createElement("<INPUT TYPE='hidden' NAME='pageMethod' VALUE='go'>");
    formObj.appendChild(oNewNode);
    
	formObj.submit();
}


function formToAbled()
{
   var from_WfActivity=document.getElementsByTagName('form')[0];
   for(var i=0;i<from_WfActivity.elements.length;i++)
    {
          from_WfActivity.elements[i].disabled=false;
   }
}

function OM_table(obj){
	obj.className='table_on';
}
function OO_table(obj){
	obj.className='table_off';
}