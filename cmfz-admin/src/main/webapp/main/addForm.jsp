<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<script type="text/javascript">
		$(function(){
			
		});
	</script>
<div style="padding-left: 50px;padding-top: 30px">
  	<form id="form" method="post">
		轮播图描述:<input class="easyui-textbox" name="pictureDescription" data-options="required:true,width:200"><br>
		轮播图状态:<select  class="easyui-combobox" name="pictureStatus" data-options="width:200">
			<option value="0">未展示</option>
			<option value="1">展示中</option>
		</select><br>
		上传轮播图:<input class="easyui-filebox" name="picturePath" data-options="width:200"><br>
	</form>
</div>