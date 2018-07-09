<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $("#datagrid_log").datagrid({
            url : "${pageContext.request.contextPath}/findLog.do",
            columns : [ [ {
                title : "标识编号",
                field : "id",
                width:500,
                align:'center'
            }, {
                title : "用户",
                field : "user",
                width:300,
                align:'center'
            }, {
                title : "照片",
                field : "time",
                width:400,
                align:'center'
            }, {
                title : "资源名",
                field : "resource",
                width:200,
                align:'center'
            }, {
                title : "操作",
                field : "action",
                width:300,
                align:'center'
            }, {
                title : "操作信息",
                field : "message",
                width:700,
                align:'center'
            }, {
                title : "结果",
                field : "result",
                width:200,
                align:'center'
            } ] ],
            height:668,
            fitColumns:true,
            pagination : true,
            pageList : [5,10,15,20],
            pageSize : 5,
            singleSelect:true,
            remoteSort:false,
            nowrap:false
        });
    });

</script>

<table id="datagrid_log"></table>
