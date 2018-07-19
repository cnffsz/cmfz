<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $("#datagrid_pic").datagrid({
            url : "${pageContext.request.contextPath}/findPicture.do",
            columns : [ [ {
                title : "标识编号",
                field : "pictureId",
                width:500,
                align:'center'
            }, {
                title : "轮播图路径",
                field : "picturePath",
                width:400,
                align:'center'
            }, {
                title : "描述信息",
                field : "pictureDescription",
                width:500,
                align:'center'
            }, {
                title : "轮播图状态",
                field : "pictureStatus",
                width:200,
                align:'center',
                formatter: function (value, row, index) {
                    if(value==0)
                        return "未展示";
                    else
                        return "展示中";
                },
                styler: function(value,row,index){
                    if (value == 1)
                        return 'color:red;';
                }
            }, {
                title : "轮播图创建时间",
                field : "pictureDate",
                width:400,
                align:'center'
            }, {
                title: "操作",
                field: "operation",
                width:400,
                align:'center',
                formatter: function (value, row, index) {
                    return '<a name="picA" class="easyui-linkbutton" data-options="iconCls:\'icon-edit\',plain:true" onclick="updatePic()">修改</a>';
                }
            } ] ],
            height:668,
            fitColumns:true,
            pagination : true,
            pageList : [5,10,15,20],
            pageSize : 5,
            singleSelect:true,
            toolbar: "#tool_pic",
            onLoadSuccess:function (data) {
                $("a[name='picA']").linkbutton({});
            },
            remoteSort:false,
            nowrap:false,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="http://192.168.73.128:8888/' + rowData.picturePath + '" style="height:200px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            }

        });
    });
    function addPic() {
        $("#d1_pic").dialog({
            width:400,
            height:200,
            title:"新增轮播图",
            iconCls:"icon-add",
            collapsible:true,
            maximizable:true,
            align:'center',
            href:"${pageContext.request.contextPath}/main/addForm_pic.jsp",
            modal:true,
            shadow:true,
            buttons:[{
                iconCls:"icon-disk",
                text:"保存",
                handler:function(){
                    $("#form_pic").form("submit",{
                        url:"${pageContext.request.contextPath}/addPicture.do",
                        onSubmit:function(){
                            return $("#form_pic").form("validate");
                        },
                        success:function(r){
                            if(r=="success"){
                                $("#datagrid_pic").datagrid({
                                    url : "${pageContext.request.contextPath}/findPicture.do"
                                });
                                $.messager.show({
                                    title:"通知",
                                    msg:"添加成功",
                                    timeout:3000,
                                    showType:"slider",
                                });
                            }else{
                                $.messager.show({
                                    title:"通知",
                                    msg:"添加失败",
                                    timeout:3000,
                                    showType:"slider",
                                });
                            }
                        }
                    });
                    $("#d1_pic").dialog("close");
                }
            },{
                iconCls:"icon-cancel",
                text:"取消",
                handler:function(){
                    $("#d1_pic").dialog("close");
                }
            }]
        });
    }

    function updatePic() {
        $("#d1_pic").dialog({
            width:400,
            height:200,
            title:"修改轮播图",
            collapsible:true,
            maximizable:true,
            href:"${pageContext.request.contextPath}/main/updateForm_pic.jsp",
            modal:true,
            shadow:true,
            onLoad:function(){
                var rowData = $("#datagrid_pic").datagrid("getSelected");
                $("#form1_pic").form("load",rowData);
            },
            buttons:[{
                iconCls:"icon-disk",
                text:"保存",
                handler:function(){
                    $("#form1_pic").form("submit",{
                        url:"${pageContext.request.contextPath}/modifyPicture.do",
                        onSubmit:function(){
                            return $("#form1_pic").form("validate");
                        },
                        success:function(r){
                            if(r=="success"){
                                $("#datagrid_pic").datagrid({
                                    url : "${pageContext.request.contextPath}/findPicture.do"
                                });
                                $.messager.show({
                                    title:"通知",
                                    msg:"修改成功",
                                    timeout:3000,
                                    showType:"slider",
                                });
                            }else{
                                 $.messager.show({
                                    title:"通知",
                                    msg:"修改失败",
                                    timeout:3000,
                                    showType:"slider",
                                });
                            }
                        }
                    });
                    $("#d1_pic").dialog("close");
                }
            },{
                iconCls:"icon-cancel",
                text:"取消",
                handler:function(){
                    $("#d1_pic").dialog("close");
                }
            }]
        });
    }
</script>

<table id="datagrid_pic"></table>

<div id="tool_pic">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'" onclick="addPic()"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
</div>

<div id="d1_pic"></div>

