<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../../../assets/lib/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../../../assets/lib/easyui/themes/icon.css">   
<script type="text/javascript" src="../../../assets/lib/jquery/jquery-1.8.3.min.js"></script>   
<script type="text/javascript" src="../../../assets/lib/easyui/jquery.easyui.min.js"></script> 
 
 
</head>
<body>


 <div id="cc" class="easyui-layout" fit='true'> 
	<div data-options="region:'north',title:'查询条件',split:true" style="height:130px;">
	    	<table >
	    		<tr>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" name="name" ></input></td>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" name="name" ></input></td>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" name="name" ></input></td>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" name="name" ></input></td>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" name="name" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>订单类型:</td>
	    			<td><input class="easyui-textbox" type="text" name="email" data-options="validType:'email'"></input></td>
	    			<td>订单类型:</td>
	    			<td><input class="easyui-textbox" type="text" name="email" data-options="validType:'email'"></input></td>
	    			<td>订单类型:</td>
	    			<td><input class="easyui-textbox" type="text" name="email" data-options="validType:'email'"></input></td>
	    			<td>订单类型:</td>
	    			<td><input class="easyui-textbox" type="text" name="email" data-options="validType:'email'"></input></td>
	    			<td>订单类型:</td>
	    			<td><input class="easyui-textbox" type="text" name="email" data-options="validType:'email'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Subject:</td>
	    			<td><input class="easyui-textbox" type="text" name="subject" ></input></td>
	    			<td>Subject:</td>
	    			<td><input class="easyui-textbox" type="text" name="subject" ></input></td>
	    			
	    			<td ></td>
	    			<td ></td>
	    			<td ></td>
	    			<td ></td>
	    			<td ></td>
	    			<td ></td>
	    			<td >
	    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
	    			</td>
	    		</tr>
	    	</table>
	</div> 
	<div data-options="region:'center',title:'查询结果'" >
		 <table id="dg"></table>  
	</div> 
</div>

<script type="text/javascript">



$(function(){
	initGrid();
});


function initGrid(){
	
	$('#dg').datagrid({    
	    fit:true,
	    fitColumns:true,
	    rownumbers:true,
	    idField:'id',
	    toolbar: [{
					iconCls: 'icon-edit',
					text:'添加',
					handler: function(){alert('编辑按钮')}
				},'-',{
					iconCls: 'icon-help',
					text:'帮助',
					handler: function(){alert('帮助按钮')}
				}],
	    columns:[
	            
	             [    
			        {field:'id',title:'id',hidden:true},
			        {field:'checkbox',checkbox:true},    
			        {field:'code',title:'编码',width:1},    
			        {field:'name',title:'昵称',width:1},    
			        {field:'price',title:'余额',width:1} 
		        ]
	            ]  ,
	    pagination:true,
	    pageSize:15
	}); 
	
	$('#dg').datagrid({
		data: [
			{id:1,code:'0001', name:'张三',price:'123'},
			{id:2,code:'0001', name:'张三',price:'123'},
			{id:3,code:'0001', name:'张三',price:'123'},
			{id:4,code:'0001', name:'张三',price:'123'},
			{id:5,code:'0001', name:'张三',price:'123'},
			{id:6,code:'0001', name:'张三',price:'123'},
			{id:7,code:'0001', name:'张三',price:'123'},
			{id:8,code:'0001', name:'张三',price:'123'},
			{id:9,code:'0001', name:'张三',price:'123'},
			{id:10,code:'0001', name:'张三',price:'123'},
			{id:11,code:'0001', name:'张三',price:'123'},
			{id:12,code:'0001', name:'张三',price:'123'},
			{id:13,code:'0001', name:'张三',price:'123'},
			{id:14,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'},
			{id:15,code:'0001', name:'张三',price:'123'}
			
		]
	});

}
	
	
</script>
	 
</body>
</html>