<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>课程安排</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style type="text/css">
table,table td,table th {
	border: 1px solid #ff0000;
	border-collapse: collapse;
}
</style>
</head>

<body>
	<form id="formid" name="formid" method='post' action=""
		onsubmit="return submit(1);">
		<font>余额:<%=request.getAttribute("balance")%>元
		</font>
		<table>
			<tr>
				<td align="right"><label class="Validform_label"> 收信人:
				</label></td>
				<td class="value"><textarea rows="10" cols="50" id="tels"
						name="tels">${smsData.tels}</textarea> <span
					class="Validform_checktip"></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 短信内容:
				</label></td>
				<td class="value"><textarea defaultValue="最大长度70" rows="5"
						cols="50" id="context" name="context" onkeyup="check(this)">${smsData.context}</textarea>
					<div id="count"></div> <span class="Validform_checktip"></span></td>

			</tr>
			<tr>
				<td align="right" colspan="2"><input type="button" value="批量发送"
					style="width: 80px; height: 40px; font-size: 20;"
					onclick="checkSubmit();" /></td>
			</tr>
		</table>

	</form>
	<div id="msg"
		style="position: absolute; height: 200px; width: 200px; overflow: auto"></div>
	<script type="text/javascript">
		function check(obj) {
			var len = 70;
			var cueObj = document.getElementById("count");
			var length = len - obj.value.length;
			if (length < 1) {
				obj.value = obj.value.substring(0, len);
			}
			var cue = "你还能输入" + length + "字";
			cueObj.innerHTML = "<div>" + cue + "</div>"
		}

		function checkSubmit() {

			//获取接受返回信息层
			var msg = document.getElementById("msg");
			msg.innerHTML = "正在发送,请稍候....";
			//获取表单对象和用户信息值
			var f = document.formid;
			var tels = f.tels.value;
			var sendMsg = f.context.value;

			var postStr = "";
			//接收表单的URL地址
			var url = "sMSController.do?save";
			//需要POST的值，把每个变量都通过&来联接 
			var postStr = "tels=" + tels + "&sendMsg=" + sendMsg;

			//实例化Ajax
			var ajax = null;
			if (window.XMLHttpRequest) {
				ajax = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				ajax = new ActiveXObject("Microsoft.XMLHTTP");
			} else {
				return;
			}

			//通过Post方式打开连接
			ajax.open("POST", url, true);
			//定义传输的文件HTTP头信息 
			ajax.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			//发送POST数据
			ajax.send(postStr);
			//返回数据的处理函数

			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4 && ajax.status == 200) {
					msg.innerHTML = "";
					msg.innerHTML += ajax.responseText.replace(new RegExp("\"",
							"gm"), "");
				}
			}
		}
	</script>
</body>