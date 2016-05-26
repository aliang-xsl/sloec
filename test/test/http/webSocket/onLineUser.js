/**
 * 
 * 用户在线检测
 * 
 */

var ws=false;

(function senderSocket(){
	
	if(window.WebSocket){
		
		var url="ws://localhost/webSocketTest";
		ws=new WebSocket(url);
		ws.onopen=function(){console.info("握手成功！");};
		ws.onmessage =function(event){console.info(event);};
		ws.onclose = function(){console.info("关闭！");};
		
		setInterval(function(){ws.send(Math.random());},5000);
	}
	else{
		setInterval(function(){ajaxOnlineUser();},5000);
	}
})();




function ajaxOnlineUser(){
	Ext.Ajax.request({
		url : baseUrl + '/user/heartbeat',
		params : {
		},
		method : 'post',
		callback : function(options, success, response) {
			var msg = Ext.JSON.decode(response.responseText);
			console.info(msg);
		},
		failure : function(response, opts) {
			Ext.Msg.alert('系统提示', "你已掉线！");
		}
	});
	
}
