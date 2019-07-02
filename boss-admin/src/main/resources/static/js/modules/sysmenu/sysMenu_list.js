//获取隐藏域的值
var contextPath = document.getElementById('contextPath').value;

var _tool = null;

layui.use(['form','layer','table','laytpl','laydate'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        laydate = layui.laydate,
        table = layui.table;

    var index = layer.load(1);

    
    //渲染数据表格菜单表列表
    var tableIns = table.render({
        elem: '#sysMenuList',
        url : contextPath + '/sysMenu/listSysMenus',
        cellMinWidth : 150,
        page : true,
        /*height : "full-200",*/
        limits : [10,15,20,25],
        limit : 15,
        id : 'sysMenuListTable',
        method : 'get',
        request : {
            pageName : 'currentPage',
            limitName : 'pageSize'
        },
        response: {
            statusCode: 1 //重新规定成功的状态码为 1，table 组件默认为 0
        },
        done : function () {
            layer.close(index);
        },
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: 'id', width:200, align:"center", },
            {field: 'menuName', title: '菜单名称', width:200, align:"center", },
            {field: 'parentId', title: '父级菜单id', width:200, align:"center", },
            {field: 'menuUrl', title: '菜单地址', width:200, align:"center", },
            {field: 'permission', title: '权限', width:200, align:"center", },
            {field: 'sequence', title: '次序', width:200, align:"center", },
            {field: 'menuIcon', title: '菜单图标', width:200, align:"center", },
            {field: 'remark', title: '备注', width:200, align:"center", },
            {title: '操作', width:220, fixed:"right", templet:'#sysMenuListBar',align:"center"}
        ]]
    });

    //顶部查询
    form.on('submit(searchBtn)', function(data){
        var index = layer.load(1);
        //重新渲染数据表格
        table.reload("sysMenuListTable",{
            page: {
                curr : 1 //layui此处有点bug 前一步已经把curr改为currentPage了，但此处仍为curr
            },
            where: data.field,
            done : function () {
                layer.close(index);
            }
        });
        //禁止表单提交
        return false;
    });

    //toolbar事件
    table.on('tool(sysMenuList)',function (obj) {
        var event = obj.event;
        var data = obj.data;
        if(event === 'edit'){//修改按钮
            layerBox({
                title : '修改菜单表',
                url : contextPath + "/sysMenu/toEditSysMenu?id="+data.id
            });
        }else if(event === 'delete'){//删除按钮
            layer.confirm('你确定删除吗?', {icon: 3, title:'提示'}, function(index){
                var loading = layer.load(1);
                $.ajax({
                    type : 'post',
                    url : contextPath + '/sysMenu/remove',
                    data : {
                        "id": data.id
                    },
                    dataType : 'json',
                    success : function (result) {
                        if(resSuccess(result.code)){
                            layer.close(loading);
                            layer.close(index);
                            //重新渲染数据表格
                            reloadTable(1);

                            succMsg('删除成功！');
                        }else{
                            layer.close(loading);
                            layer.close(index);
                            failMsg();
                        }
                    },
                    error : function () {
                        layer.close(loading);
                        layer.close(index);
                        failMsg();
                    }
                })
            });
        }else if(event === 'other'){//其他按钮
            layer.msg("无其他事件~~~");
        }
    });

    //添加菜单表
    $('#btn_add').on('click',function () {
        layerBox({
            title : '添加菜单表',
            url : contextPath + "/sysMenu/toAddSysMenu"
        })
    });



    //批量删除
    $('#btn_delete_all').on('click',function () {
        var datas = table.checkStatus('sysMenuListTable').data;
        if(datas.length <= 0){
            warnMsg('请先选择数据！');
        }else{
            layer.confirm('你确定删除选中的数据吗?', {icon: 3, title:'提示'}, function(index){
                var loading = layer.load(1);
                var ids = "";
                datas.forEach(function (data) {
                    ids = ids + data.id + ','
                });
                ids = ids.substring(0,ids.length-1);

                $.ajax({
                    type : 'post',
                    url : contextPath + '/sysMenu/batchRemove',
                    data : {
                        "ids[]": ids
                    },
                    dataType : 'json',
                    success : function (result) {
                        if(resSuccess(result.code)){
                            layer.close(loading);
                            layer.close(index);
                            //重新渲染数据表格
                            reloadTable(1);

                            succMsg('批量删除成功！');
                        }else{
                            layer.close(loading);
                            layer.close(index);
                            failMsg();
                        }
                    },
                    error : function () {
                        layer.close(loading);
                        layer.close(index);
                        failMsg();
                    }
                })
            });
        }
    });

    //其他菜单表
    $('#btn_other_all').on('click',function () {
        layer.msg("其他");
    });
    
    //刷新数据表格
    function reloadTable(currentPage) {
        var searchForm  = $('#searchForm').serializeArray();

        //重新渲染数据表格
        if(currentPage != null){
            table.reload("sysMenuListTable",{
                page: {
                    currentPage : currentPage
                },
                where: {
                    id : searchForm[0].value,
                    menuName : searchForm[1].value,
                    parentId : searchForm[2].value,
                    menuUrl : searchForm[3].value,
                    permission : searchForm[4].value,
                    sequence : searchForm[5].value,
                    menuIcon : searchForm[6].value,
                    remark : searchForm[7].value,
                    time : new Date().getTime()
                },
                done : function () {
                    layer.close(index);
                }
            });
        }else{
            table.reload("sysMenuListTable",{
                where: {
                    id : searchForm[0].value,
                    menuName : searchForm[1].value,
                    parentId : searchForm[2].value,
                    menuUrl : searchForm[3].value,
                    permission : searchForm[4].value,
                    sequence : searchForm[5].value,
                    menuIcon : searchForm[6].value,
                    remark : searchForm[7].value,
                    time : new Date().getTime()
                },
                done : function () {
                    layer.close(index);
                }
            });
        }
    }

    //用于子iframe刷新数据表格
    window.searchReload = function (currentPage) {
        reloadTable(currentPage);
    }
});
