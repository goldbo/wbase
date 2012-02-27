/*
 * Ext JS Library 2.0.2
 * Copyright(c) 2006-2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */



    Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
    var win;

    // example of custom renderer function
    function change(val){
        if(val > 0){
            return '<span style="color:green;">' + val + '</span>';
        }else if(val < 0){
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    }

    // example of custom renderer function
    function pctChange(val){
        if(val > 0){
            return '<span style="color:green;">' + val + '%</span>';
        }else if(val < 0){
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    }
    function convert(d_value){
    	if(d_value==null||d_value==""){
    		return "";
    	}
   	  var arys= new Array();
	  arys=d_value.split('-');
	  var newDate=new Date(arys[0],arys[1],arys[2]); 
	  return newDate;
    }
    
    // create the data store
    var item_file = Ext.data.Record.create([
		{name : 'archiveNo',mapping : 'archiveNo'},
		{name : 'category',mapping : 'category_no'},
		{name : 'retentionPeriod',mapping : 'retentionPeriod'},
		{name : 'title',mapping : 'title'},
		{name : 'startDate',mapping : 'startDate',convert:convert},
		{name : 'endDate',mapping : 'endDate',convert:convert},
		{name : 'totalPackage',mapping : 'totalPackage'},
		{name : 'totalPages',mapping : 'totalPages'},
		{name : 'archiveBranch',mapping : 'archiveBranch'},
		{name : 'annual',mapping : 'annual'},
		{name : 'securityClassification',mapping : 'securityClassification'},
		{name : 'description',mapping : 'description'},
		{name : 'collator',mapping : 'collator'},
		{name : 'rummager',mapping : 'rummager'},
		{name : 'remark',mapping : 'remark'},
		{name : 'objStowedPosition',mapping : 'objStowedPosition'},
		{name : 'genus',mapping : 'genus'}
	]);
	
	var accessories = Ext.data.Record.create([
		{name:'archiveNo',mapping:'archiveNo'},
		{name:'number',mapping:'number'},
		{name:'accessories',mapping:'accessories'}
	]);
	
	var inner_file = Ext.data.Record.create([
		{name : 'archiveNo',mapping : 'archiveNo'},
		{name : 'number',mapping : 'number'},
		{name : 'retentionPeriod',mapping : 'retentionPeriod'},
		{name : 'docNo',mapping : 'docNo'},
		{name : 'responsible',mapping : 'responsible'},
		{name : 'title',mapping : 'title'},
		{name : 'docFormationTime',mapping : 'docFormationTime',convert:convert},
		{name : 'startPage',mapping : 'startPage'},
		{name : 'endPage',mapping : 'endPage'},
		{name : 'pageAmount',mapping : 'pageAmount'},
		{name : 'secuClassification',mapping : 'secuClassification'},
		{name : 'mainSupplyBranch',mapping : 'mainSupplyBranch'},
		{name : 'copyBranch',mapping : 'copyBranch'},
		{name : 'description',mapping : 'description'},
		{name : 'archiveBranch',mapping : 'archiveBranch'},
		{name : 'theme',mapping : 'theme'},
		{name : 'annual',mapping : 'annual'},
		{name : 'content',mapping : 'content'},
		{name : 'remark',mapping : 'remark'}
	]);
	
	var submit_archive = new Ext.Window({
		width:600,
        height:150,
        closeAction:'hide',
        plain: true,
        title:'请选择提交条件',
        items:[
        	new Ext.FormPanel({
	        	autoTabs:true,
	            activeTab:0,
	            deferredRender:false,
	            border:false,
		        frame : true,
		        layout : 'column',
		        items:[{
			        columnWidth : .5,
	           	 	layout : 'form',
	            	border : false,
	            	labelAlign : 'left',
	            	items : [{
			    		xtype : 'textfield',
	            		width : 150,
		                fieldLabel : '归档号',
		                name : 'archiveNo'
			    	},cbb_category]
		        },{
		        	columnWidth : .5,
	           	 	layout : 'form',
	            	border : false,
	            	labelAlign : 'left',
	            	items:[year_combo,cbb_dept]
		        }],
		        buttons : [{
		        	text:'提交',
		        	handler : function() {
		        		var form = this.ownerCt.form;
		        		var condition=form.findField('archiveNo').getValue();
				        var category=form.findField('category').getValue();
	        			var archiveBranch=form.findField('archiveBranch').getValue();
	        			var annual=form.findField('annual').getValue();
	        			if((condition=='' || condition==null)
	        				&&(category==null || category=='')
	        				&&(archiveBranch==null || archiveBranch=='')
	        				&&(annual==null || annual=='')){
		        			Ext.MessageBox.alert("提示","请选择提交条件！");
		        			return;
	        			}
		        		Ext.Ajax.request({url: "searchFileInfoAction.do?executeCommand=UPDATE_ROLL_STATUS_BARCH", 
				        	params : {condition:condition,
				        			category:category,
				        			archiveBranch:archiveBranch,
				        			annual:annual
				        	}, 
				        	success: function(response, options){
				        		Ext.MessageBox.alert("提示","案卷信息提交成功！");
				        	},  
				        	failure: function( response, options) {
				        		Ext.MessageBox.alert("提示","提交信息失败！");
				        		return;
				        	} 
		        		})	
		        	}
		        }]
        	})
        ]
	});
	
var store = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'searchFileInfoAction.do?executeCommand=SEARCH_ROLL_FILE'
	}),
    reader: new Ext.data.JsonReader({   
		root: 'root',   
		totalProperty:'totalProperty'  
		},item_file)

});
store.baseParams.status='0';
store.load({
		params : {start : 0,limit : 10},
		callback:function(r,options,success){
			if(!success){
				Ext.Msg.show({
				title: '错误提示',
				msg: "错误提示",
				width: 300,
				buttons: Ext.MessageBox.OK,
				icon:Ext.MessageBox.ERROR
				});
			}else{
			//alert(store.getCount());
			}
			}
		
	});
    
    var accessories_store = new Ext.data.Store({
    	proxy : new Ext.data.HttpProxy({
		url : 'searchFileInfoAction.do?executeCommand=SEARCH_INNER_ACCESSORIES'
	}),
    reader: new Ext.data.JsonReader({   
		root: 'root',   
		totalProperty:'totalProperty'  
		},accessories)
    });
    
    
var store1 =new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'WaitProcessDataAction.do?executeCommand=SEARCH_INNER_FILE_FOR_WAIT_DATA'
	}),
    reader: new Ext.data.JsonReader({   
		root: 'root',   
		totalProperty:'totalProperty'  
		},inner_file)

});
    
    

var btn_ipt_file_info = new Ext.Button({
	text : '案卷信息录入',
	iconCls : 'icon-add',
	handler : function() {
        window_add_data.show();
	}
});
 var btn_upload_file = new Ext.Button({
	text : '附件信息',
	iconCls : 'icon-add',
	handler : function() {
	var record = grid_inner_file.getSelectionModel().getSelected();
	if((record+"")=="undefined"){
			Ext.MessageBox.alert("提示","请选择卷内文件!");
			return;
		}
	accessories_store.load({
	params : {condition : record.get("archiveNo"),condition_number : record.get("number")}
	});
		win_upload_dialog();
        win.show();
	}
});

 var btn_refresh_accessories = new Ext.Button({
 text : '刷新',
	iconCls : 'icon-del',
	handler : function() {
	var record = grid_inner_file.getSelectionModel().getSelected();
	accessories_store.load({
	params : {condition : record.get("archiveNo"),condition_number : record.get("number")}
	});
	}
 });

 var btn_updata_status = new Ext.Button({
 text : '提交选中案卷',
	iconCls : 'icon-del',
	handler : function() {
		var records = grid.getSelectionModel().getSelections();
		if(records.length==0) {
			Ext.MessageBox.alert("提示","请选择行");
			return;
		}
		var record;
		Ext.Msg.confirm('确认提交', '你确定提交此案卷?', function(btn) {
			for(var i = 0;i<records.length;i++){
				record=records[i];
				Ext.Ajax.request({url: "searchFileInfoAction.do?executeCommand=UPDATE_ROLL_STATUS", 
			        params : {condition:record.get("archiveNo")}, 
			        success: function(response, options){
			        	//grid.getStore().remove(record);
			        },  
			        failure: function( response, options) {
			        	Ext.MessageBox.alert("提示","数据提交失败！");
			        	return;
			        } 
		        }); 
	        }
	        for(var i = 0;i<records.length;i=i+1){
				record =  records[i];
				grid.getStore().remove(record);
				grid_inner_file.getStore().removeAll();
			}
		})
		
	}
 });


 var btn_updata_batch_roll_file = new Ext.Button({
 	text : '批量提交案卷',
	iconCls : 'icon-del',
	handler : function() {
	submit_archive.show();
	}
 });


 var btn_del_accessories = new Ext.Button({
	text : '删除附件',
	iconCls : 'icon-del',
	handler : function() {
		var record = accessories_grid.getSelectionModel().getSelected();
		if(record){
			Ext.Msg.confirm('确认删除', '你确定删除此附件?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'searchFileInfoAction.do?executeCommand=DELETE_INNER_FILE_ACCESSORIES',
						params : {
							condition : record.get("archiveNo"),
							condition_number : record.get("number"),
							accessoriesName:record.get("accessories")
						},
						success : function(response, options) {
							var responseArray = Ext.util.JSON.decode(response.responseText);
	   						if(responseArray.result == "success"){
								accessories_grid.getStore().remove(record);
								Ext.MessageBox.alert("提示","数据删除成功");
							}else{
								Ext.MessageBox.alert("提示","数据删除失败");
							}
						},
						failure : function() {
							Ext.MessageBox.alert("提示","数据删除失败");
						}
					});
				}
			});
		}
	}
});

var del_roll_info = new Ext.Button({
	text : '删除选中卷',
	iconCls : 'icon-del',
	handler : function() {
		var records = grid.getSelectionModel().getSelections();
		if(records.length==0) {
			Ext.MessageBox.alert("提示","请选择行");
			return;
		}
		//var record;
		//if(true){
		
			Ext.MessageBox.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				for(var i = 0;i<records.length;i=i+1){
					record =  records[i];
					if (btn == 'yes') {
						Ext.Ajax.request({
							url : 'WaitProcessDataAction.do?executeCommand=DELETE_ARCHIVE_INFO_FOR_WAIT_DATA',
							params : {
								condition : record.get("archiveNo")
							},
							success : function(response, options) {
								var responseArray = Ext.util.JSON.decode(response.responseText);
		   						if(responseArray.result == "success"){
									
								}else{
									Ext.MessageBox.alert("提示","数据删除失败");
									return;
								}
							},
							failure : function() {
								Ext.MessageBox.alert("提示","数据删除失败");
							}
						});
					}
				}
			});
		//}
		for(var i = 0;i<records.length;i=i+1){
			record =  records[i];
			grid.getStore().remove(record);
			grid_inner_file.getStore().removeAll();
		}
		//Ext.MessageBox.alert("提示","数据删除成功");
	}
});
var del_inner_info = new Ext.Button({
	text : '删除选中卷内文件',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_inner_file.getSelectionModel().getSelected();
		if(record){
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'searchFileInfoAction.do?executeCommand=DEL_INNER_FILE',
						params : {
							condition : record.get("archiveNo"),
							condition_docNo : record.get("docNo")
						},
						success : function(response, options) {
							var responseArray = Ext.util.JSON.decode(response.responseText);
	   						if(responseArray.result == "success"){
								//grid.getStore().remove(record);
								grid_inner_file.getStore().remove(record);
								Ext.MessageBox.alert("提示","数据删除成功");
							}else{
								Ext.MessageBox.alert("提示","数据删除失败");
							}
						},
						failure : function() {
							Ext.MessageBox.alert("提示","数据删除失败");
						}
					});
				}
			});
		}
	}
});
var checkBox = new Ext.grid.CheckboxSelectionModel();
    // create the Grid
    
      var grid = new Ext.grid.EditorGridPanel({
        ds: store,
        sm : checkBox,
        columns: [
        checkBox,
            {id:'归档号',header: "归档号", width: 160, sortable: true, dataIndex: 'archiveNo'},
            {header: "档案类别", width: 75, sortable: true, dataIndex: 'category',editor:cbb_category},
            {header: "保管期限", width: 75, sortable: true, dataIndex: 'retentionPeriod',editor : cbb_keep_time},
            {header: "题名", width: 85, sortable: true, dataIndex: 'title',editor : new Ext.form.TextArea({
			allowBlank : false
		})},
            {header: "起始日期", width: 75, sortable: true,renderer: Ext.util.Format.dateRenderer('Y-m-d'), dataIndex: 'startDate',editor : new Ext.form.DateField({
            format: 'Y-m-d'
        })},
            {header: "终止日期", width: 75, sortable: true,renderer: Ext.util.Format.dateRenderer('Y-m-d'),  dataIndex: 'endDate',editor : new Ext.form.DateField({
            format: 'Y-m-d'
        })},
            {header: "总件数", width: 75, sortable: true,  dataIndex: 'totalPackage',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "总页数", width: 75, sortable: true, dataIndex: 'totalPages',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "归档部门", width: 75, sortable: true,dataIndex: 'archiveBranch',editor : cbb_dept},
            {header: "年度", width: 75, sortable: true,  dataIndex: 'annual',editor : year_combo},
            {header: "密级", width: 75, sortable: true, dataIndex: 'securityClassification',editor : cbb_privacy_step},
            {header: "著录", width: 75, sortable: true, dataIndex: 'description',editor : new Ext.form.TextArea({
			allowBlank : false
		})},
            {header: "整理人", width: 75, sortable: true, dataIndex: 'collator',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "检查人", width: 75, sortable: true, dataIndex: 'rummager',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "实物存放位置", width: 75, sortable: true, dataIndex: 'objStowedPosition',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "属类", width: 75, sortable: true,dataIndex: 'genus',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "备注", width: 75, sortable: true,dataIndex: 'remark',editor : new Ext.form.TextArea({
			allowBlank : false
		})}
        ],
        bbar : new Ext.PagingToolbar({
			pageSize : 10,
			store : store,
			displayInfo : true
		}),
        listeners : {
		'afteredit' : function(e) {//alert(Ext.util.Format.date(e.value,'Y-m-d'));return;
			var cValue="";
			if(e.field=="archiveNo"){
				cValue=e.originalValue;
			}else{
				cValue=e.record.data.archiveNo;
			}
			var e_Value;
			 if((typeof e.value=='object')&&e.value.constructor==Date){
				e_Value=Ext.util.Format.date(e.value,"Y-m-d");
			 }else{
			 	e_Value = e.value;
			 }
			Ext.Ajax.request({
				url : 'WaitProcessDataAction.do?executeCommand=EDIT_ARCHIVE_INFO_FOR_WAIT_DATA',
				params : {
					tableName : 'tb_roll_file_temp',
					fieldName : e.field,
					fieldValue : e_Value,
					condition : 'archiveNo',
					conditionValue : cValue//e.record.data.archiveNo
				},
				success : function() {
					
				},
				failure : function() {
					Ext.Msg.show({
						title : '错误提示',
						msg : '修改数据发生错误,操作将被回滚!',
						fn : function() {
							e.record.set(e.field, e.originalValue);
						},
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		},
		'cellclick':function(grid, rowIndex){
			grid_inner_file.getStore().removeAll();
			store1.baseParams.condition = grid.getStore().getAt(rowIndex).data.archiveNo;
			store1.load({params : {start : 0,limit : 10}});
		}
	},
        editor:true,
        tbar :[btn_ipt_file_info,'-',del_roll_info,'-',btn_updata_status,'-',btn_updata_batch_roll_file],
        width:Ext.getBody().getComputedWidth()-20
    });
    
    var accessories_grid = new Ext.grid.EditorGridPanel({
	    ds:accessories_store,
	    sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	    tbar:[btn_del_accessories,'-',btn_refresh_accessories],
	    columns: [
	    	 {id:'归档号',header: "归档号", width: 160, sortable: true, dataIndex: 'archiveNo'},
	    	 {header: "序号", width: 75, sortable: true, renderer: change, dataIndex: 'number'},
	    	 {header: "附件", width: 200, sortable: true, renderer: change, dataIndex: 'accessories'}
	    ]
    });
    
    var grid_inner_file = new Ext.grid.EditorGridPanel({
        ds: store1,
        tbar : [del_inner_info,'-',btn_upload_file],
        sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
        columns: [
            {id:'归档号',header: "归档号", width: 160, sortable: true, dataIndex: 'archiveNo'},
            {header: "保管期限", width: 75, sortable: true, renderer: change, dataIndex: 'retentionPeriod',editor : cbb_keep_time},
            {header: "文件编号", width: 85, sortable: true, dataIndex: 'docNo',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "责任者", width: 75, sortable: true, dataIndex: 'responsible',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "标题", width: 75, sortable: true,dataIndex: 'title',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "日期", width: 75, sortable: true,renderer: Ext.util.Format.dateRenderer('Y-m-d'),dataIndex: 'docFormationTime',editor : new Ext.form.DateField({
            format: 'Y-m-d'
        })},
            {header: "起始页", width: 75, sortable: true,dataIndex: 'startPage',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "终止页", width: 75, sortable: true,dataIndex: 'endPage',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "页数", width: 75, sortable: true,dataIndex: 'pageAmount',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "密级", width: 75, sortable: true,dataIndex: 'secuClassification',editor : cbb_privacy_step},
            {header: "主送单位", width: 75, sortable: true, dataIndex: 'mainSupplyBranch',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "抄送单位", width: 75, sortable: true, dataIndex: 'copyBranch',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "著录", width: 75, sortable: true,dataIndex: 'description',editor : new Ext.form.TextArea({
			allowBlank : false
		})},
            {header: "归档部门", width: 75, sortable: true,dataIndex: 'archiveBranch',editor : cbb_dept},
            {header: "主题词", width: 75, sortable: true,dataIndex: 'theme',editor : new Ext.form.TextField({
			allowBlank : false
		})},
            {header: "全文", width: 75, sortable: true,dataIndex: 'content',editor : new Ext.form.TextArea({
			allowBlank : false
		})},
            {header: "年度", width: 75, sortable: true,dataIndex: 'annual',editor : year_combo},
		{header: "序号", width: 75, sortable: true,dataIndex: 'number'},
            {header: "备注", width: 75, sortable: true,dataIndex: 'remark',editor : new Ext.form.TextArea({
			allowBlank : false
		})}
            
        ],
        bbar : new Ext.PagingToolbar({
			pageSize : 10,
			store : store1,
			displayInfo : true
		}),
        listeners : {
				'afteredit' : function(e) {//alert(Ext.util.Format.date(e.value,'Y-m-d'));return;
					var cValue="";
					if(e.field=="archiveNo"){
						cValue=e.originalValue;
					}else{
						cValue=e.record.data.archiveNo;
					}
					Ext.Ajax.request({
						url : 'WaitProcessDataAction.do?executeCommand=EDIT_ARCHIVE_INFO_FOR_WAIT_DATA',
						params : {
							tableName : 'tb_inner_file_temp',
							fieldName : e.field,
							fieldValue : e.value,
							condition : 'archiveNo',
							conditionValue : cValue,//e.record.data.archiveNo,
							jsonStr : "number="+e.record.data.number
						},
						success : function() {
							
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '修改数据发生错误,操作将被回滚!',
								fn : function() {
									e.record.set(e.field, e.originalValue);
								},
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
						}
					});
				},
				'rowdblclick':function(grid, rowIndex){
		//			ds_inner_file.baseParams.condition = grid.getStore().getAt(rowIndex).data.archiveNo;
		//			ds_inner_file.load({params : {start : 0,limit : 10}});
				}
			},
        editor:true,
        width:Ext.getBody().getComputedWidth()-20
    });
    
    
    var file_info_panel = new Ext.Panel({
	title : '案卷目录信息',
	iconCls : 'icon-plugin',
	region : 'center',
	border : 'layout',
	frame : true,
	layout:'border',
	defaults: {
	    collapsible: true,
	    split: true
	},
	items: [{
	    region:'center',
	    layout :'fit',
	    items : [grid]
	},{
	    region: 'south',
	    layout :'fit',
		title : '卷内文件信息',
	    height: 250,
	    minSize: 150,
	    maxSize: 286,
	    items : [grid_inner_file]
	}]
});