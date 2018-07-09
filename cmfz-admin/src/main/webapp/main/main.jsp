<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/wangEditor.min.js"></script>
<script type="text/javascript">
    $(function() {
        $.ajax({
            type: 'POST',
            async: false,
            dataType: "json",
			data:"parentId="+0,
            url: '${pageContext.request.contextPath}/findMenu.do',//获取菜单
            success: function(data) {
                $.each(data, function(index, value) {
					$('#aa').accordion('add', {
						title: data[index].menuName,
						iconCls: data[index].menuIcon,
						selected: false
					});
                });
                $('#aa').accordion({
                    selected:999,
					onSelect:function (title,index) {
                        $.ajax({
                            type: 'POST',
                            async: false,
                            dataType: "json",
                            data: "parentId=" + data[index].id,
                            url: '${pageContext.request.contextPath}/findMenu.do',//获取菜单
                            success: function (data2) {
                                var pp = $('#aa').accordion('getSelected');
                                pp.empty();
                                $.each(data2, function(index, value) {
                                    pp.css("text-align","center").append('<a name="aA" class="easyui-linkbutton" data-options="iconCls:\''+data2[index].menuIcon+'\',plain:true" onclick="addTab(\''+data2[index].menuName+'\',\''+data2[index].menuUrl+'\')" >'+data2[index].menuName+'</a><br/>');
                                });
                            }
                        });
                        $("a[name='aA']").linkbutton({});
					}
                });
            }
    	});
    });
    function addTab(menuName,menuUrl) {
        var flag = $("#tt").tabs("exists",menuName);
        if(!flag){
            $("#tt").tabs("add",{
                title: menuName,
                closable:true,
                href:"${pageContext.request.contextPath}/main/"+menuUrl
            });
        }else{
            $("#tt").tabs("select",menuName);
        }
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">

		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>