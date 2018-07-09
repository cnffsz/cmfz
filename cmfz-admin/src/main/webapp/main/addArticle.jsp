<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">

    $(function () {
        $('#articleName').combobox({
            url:'${pageContext.request.contextPath}/showAll.do',
            valueField:'masterName',
            textField:'masterName'
        });
    });

    var E = window.wangEditor
    var editor = new E('#editor');
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/upload.do';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    editor.create()

    function clearArticle(){
        $("#articleForm").form('clear');
        editor.txt.html('<p><br></p>');
    }
    function addArticle(){
        var text=editor.txt.html();
        document.getElementById("editValue").value=text;
        $("#articleForm").form("submit",{
            url:"${pageContext.request.contextPath}/addArticle.do",
            success:function(res){
                if(res == "success"){
                    $.messager.show({
                        title:"提示",
                        msg:"上传成功！",
                        timeout:3000,
                        showType:"slider",
                    });
                    $("#articleForm").form('clear');
                    editor.txt.html('<p><br></p>');
                }else{
                    $.messager.show({
                        title:"提示",
                        msg:"上传失败！",
                        timeout:3000,
                        showType:"slider",
                    });
                }
            }
        });
    }
</script>

<form id="articleForm" method="post" enctype="multipart/form-data" style="padding: 50px;background-color: #ffe48d;height: 100%">
    <p>文章标题：<input id="articletitle" class="easyui-textbox" name="articleName"></p>
    <p>文章作者：<input id="articleName" value="未知" name="articleAuthor">
    <p>文章状态：<input name="articleStatus" class="easyui-switchbutton" style="width: 80px" data-options="onText:'上架',offText:'未上架'"></p>
    <input id="editValue" name="introduction" type="text" hidden="hidden">
    <p>文章内容</p>
    <div id="editor" style="width: 800px;background-color: white"></div>
    </br>
    <a id="btn" onclick="addArticle()" class="easyui-linkbutton" data-options="iconCls:'icon-database_save'">提交文章信息</a>
    <a id="btnClear" onclick="clearArticle()" class="easyui-linkbutton" data-options="iconCls:'icon-database_refresh'">重置内容</a>
</form>