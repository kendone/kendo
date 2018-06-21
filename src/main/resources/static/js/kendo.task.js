$(document).ready(function () {
    var taskId,
        taskDefKey,
        $dialog = $("<div></div>");

    $dialog.kendoDialog({
        width: "400px",
        title: "流程处理",
        visible: false,
        closable: false,
        modal: false,
        content: "<h1>是否同意</h1>",
        actions: [
            {
                text: '确定', primary: true,
                action: function (e) {
                    var approve = $("input[name='deptLeaderApproved']:checked").val();

                    if (!taskId && !taskDefKey) return;

                    $.ajax({
                        type: "post",
                        url: root + "/bpm/task/complete/" + taskId + "/" + taskDefKey,
                        data: {approve: approve},
                        success: function (e) {
                            var data = JSON.parse(e);
                            if (data.result === "success") {
                                grid1.dataSource.read();
                            } else {
                                alert("处理失败");
                            }
                        }
                    });
                }
            },
            {
                text: '关闭',
                action: function (e) {
                    e.sender.close();
                }
            }
        ]
    });

    var processDialog = $dialog.data("kendoDialog");

    var grid = $("#task-grid").kendoGrid({
        dataSource: {
            transport: {
                read: {
                    type: "post",
                    url: root + "/bpm/task/list",
                    dataType: "json"
                }
            },
            schema: {
                data: "items"
            }
        },
        toolbar: kendo.template($("#template").html()),
        columns: [
            {field: "id", title: "任务ID", width: 100},
            {field: "name", title: "任务名称", width: 150},
            {field: "taskDefKey", title: "任务节点", width: 200},
            {field: "processDefId", title: "流程定义ID", width: 150},
            {field: "processInstId", title: "流程实例ID", width: 150},
            {
                field: "createTime", title: "发起时间", width: 160,
                attributes: common.config.ALIGNCENTER
            },
            {
                command: [
                    {
                        name: "bpm-claim",
                        text: "签收",
                        //className:"k-icon k-i-copy",
                        visible: function (dataItem) {
                            return dataItem.assignee === undefined;
                        },
                        click: function (e) {
                            var tr = $(e.target).closest("tr"),
                                rowData = this.dataItem(tr);//GET THE CURRENT ROW

                            taskId = rowData.id;//GET CURRENT TASK ID

                            $.ajax({
                                type: "post",
                                url: root + "/bpm/task/claim/" + taskId,
                                success: function (e) {
                                    var data = $.parseJSON(e);
                                    if (data.result === "success") {
                                        grid1.dataSource.read();
                                    } else {
                                        alert("签收失败");
                                    }
                                }
                            })
                        }
                    },
                    {
                        name: "bpm-deal",
                        text: "处理",
                        visible: function (dataItem) {
                            return dataItem.assignee !== undefined;
                        },
                        click: function (e) {
                            //打开请假单窗口
                            //content: root+"/businessType/businessId",
                            var tr = $(e.target).closest("tr"),
                                rowData = this.dataItem(tr);//GET THE CURRENT ROW
                            //打开工作流程处理对话框
                            var contentStr = [];

                            taskId = rowData.id;//GET CURRENT TASK ID
                            taskDefKey = rowData.taskDefKey;//GET CURRENT TASK DEFINITION KEY

                            contentStr.push("<input type='radio' value='true' name='deptLeaderApproved' id='approve' checked class='k-radio'>");
                            contentStr.push("<label class='k-radio-label' for='approve'>同意</label>");
                            contentStr.push("&nbsp;&nbsp;");
                            contentStr.push("<input type='radio' name='deptLeaderApproved' value='false' id='deny' class='k-radio'>");
                            contentStr.push("<label class='k-radio-label' for='deny'>不同意</label>");
                            contentStr.push("<div style='padding: 10px 0;'></div>");
                            contentStr.push("<label for='simple-textarea' style='padding-top:1em;'>意见</label>");
                            contentStr.push("<textarea id='simple-textarea' name='deptLeaderVote' class='k-textbox' rows='10' cols='10' style='width:100%;' ></textarea>");

                            processDialog.content(contentStr.join(""));
                            processDialog.open();//OPEN PROCESS DIALOG
                        }
                    }
                ],
                width: 200
            }
        ],
        noRecords: true
    });
    var grid1 = grid.data("kendoGrid");

    $("#category").kendoDropDownList({
        dataTextField: "name",
        dataValueField: "id",
        autoBind: true,
        optionLabel: "我参与的",
        dataSource: [
            {id: 1, name: "待签收"},
            {id: 2, name: "待办理"},
            {id: 3, name: "已完成"}
        ],
        change: function () {
            kendo.alert(this.value);
        }
    });
});