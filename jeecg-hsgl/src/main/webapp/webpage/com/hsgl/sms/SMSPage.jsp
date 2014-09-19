<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>课程安排</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<%--<body style="overflow-y: hidden" scroll="no"> --%>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="SMSController.do?save">
		<input id="id" name="id" type="hidden" value="${subjectPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1"
			class="formtable">

			<tr>
				<td align="right"><label class="Validform_label"> 收信人:
				</label></td>
				<td class="value">
					<textarea rows="20" cols="15" id="tels"
						name="tels" >${smsData.tels}</textarea>
					<span
					class="Validform_checktip"></span></td>
				<td>
				<div class="form" id="filediv"></div>
				<t:upload name="telExcel" id="telExcel" multi="true" uploader=""
						extend="office" onUploadSuccess=""></t:upload></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 短信内容:
				</label></td>
				<td class="value"><textarea defaultValue="最大长度70" rows="5" cols="50" id="context"
						name="context" onkeyup="check(this)">${smsData.context}</textarea>
					<span class="Validform_checktip"></span></td>
				<td id="count"></td>
			</tr>
		</table>
	</t:formvalid>
	<script type="text/javascript">
		function check(obj) {
			var len = 70;
			var cueObj = document.getElementById("count");
			var length = len - obj.value.length;
			if (length < 1){
				obj.value = obj.value.substring(0, len);
			}
			var cue = "你还能输入" + length + "字";
			cueObj.innerHTML = "<div>" + cue + "</div>"
		}
	</script>
</body>