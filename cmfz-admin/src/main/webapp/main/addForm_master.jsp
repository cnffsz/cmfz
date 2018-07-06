<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<script type="text/javascript">
		$(function(){
			
		});
	</script>
<div style="padding-left: 50px;padding-top: 15px">
  	<form id="form_master" method="post" enctype="multipart/form-data">
		上师法号:<input class="easyui-textbox" name="masterName" data-options="required:true,width:200"><br>
		上师简介:<input class="easyui-textbox" name="masterSummary" data-options="required:true,width:200,height:50,multiline:true"><br>
		上师照片:<input class="easyui-filebox" name="masterPhoto" data-options="required:true,width:200"><br>
	</form>
</div>