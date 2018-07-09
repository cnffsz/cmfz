<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>

<script type="text/javascript">
$(function() {

    $('#ttArticle').datagrid({
		height:668,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:'${pageContext.request.contextPath}/showArticle.do',
        columns:[[
            {field:'articleId',title:'文章编号',width:100},
            {field:'articleName',title:'文章标题',width:80},
            {field:'articleAuthor',title:'所属上师',width:80},
            {field:'articleStatus',title:'文章状态',width:80},
            {field:'articleDate',title:'创建时间',width:80},
            {field:'status',title:'操作',width:80,align:'center',formatter:function(value,row,index){
                return "<a name='articleA' class='easyui-linkbutton' data-options=\"height:20,iconCls:'icon-edit'\" onClick='getArticleBtn()'>查看详情</a>";
            }}
        ]],
        onLoadSuccess:function(){
            $("a[name='articleA']").linkbutton({});
        },
        pagination:true,
        pageList : [ 5, 10, 15, 20, 25 ],
        pageSize : 10,
        toolbar : "#tb",

    });


});

function getArticleBtn(){
    $("#dialogArticle").dialog({
        iconCls:'icon-pictures',
        width:600,
        height:500,
        title:"文章详情",
        href:"${pageContext.request.contextPath}/main/showArticle.jsp",
        modal:true,
        minimizable:true,
        maximizable:true,
        onLoad:function(){
            var rowData = $("#ttArticle").datagrid("getSelected");
            document.getElementById("hh").innerHTML=rowData.articleName;
            document.getElementById("hh1").innerHTML=rowData.introduction;
        }
    });
}

</script>


<table id="ttArticle"></table>
<div id="dialogArticle"></div>

