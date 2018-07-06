<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<script type="text/javascript">
		$(function(){
			
		});
	</script>
<div style="padding-left: 50px;padding-top: 10px">
  	<form id="form1" method="post">
		轮播图编号:<input class="easyui-textbox" name="pictureId" data-options="width:220" readonly="readonly"><br>
		轮播图名称:<input class="easyui-textbox" name="picturePath" data-options="width:220" readonly="readonly"><br>
		轮播图描述:<input class="easyui-textbox" name="pictureDescription" data-options="required:true,width:220"><br>
		轮播图状态:<select  class="easyui-combobox" name="pictureStatus" data-options="width:220,panelHeight:'auto',panelWidth:220">
			<option value="0">未展示</option>
			<option value="1">展示中</option>
		</select><br>
		轮播图时间:<input class="easyui-textbox" name="pictureDate" data-options="width:220" readonly="readonly"><br>
	</form>
</div>