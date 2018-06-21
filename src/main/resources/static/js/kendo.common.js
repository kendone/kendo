/**
 * @author kendone
 */
var common = (function ($) {
    var obj = {
        convention: {
            dateFormat: "yyyy-MM-dd",
            dateTimeFormat: "yyyy-MM-dd HH:mm:ss",
            kDateFormat: "{0:yyyy-MM-dd}",
            kDateMinuteFormat: "{0:yyyy-MM-dd HH:mm}",
            kDateTimeFormat: "{0:yyyy-MM-dd HH:mm:ss}"
        },

        config: {
            ALIGNCENTER: {style: "text-align: center"},

            PAGEABLE: {
                pageSize: 14,
                previousNext: true,
                numeric: true,
                buttonCount: 10,
                refresh: true,
                pageSizes: [10, 14, 16, 18, 20, "all"],
                messages: {
                    display: "第 {0} 到 {1} 条数据，共 {2} 条数据",
                    empty: "没有数据",
                    page: "第",
                    of: "页，共 {0} 页",
                    itemsPerPage: "每页数据",
                    first: "首页",
                    previous: "上一页",
                    next: "下一页",
                    last: "尾页",
                    refresh: "刷新"
                }
            },

            MESSAGES: {
                noRows: "没有可用的记录",
                loading: "努力加载数据中……",
                requestFailed: "数据加载失败…….",
                retry: "重新加载",
                commands: {
                    edit: "编辑",
                    update: "更新",
                    canceledit: "取消",
                    create: "新增",
                    createchild: "添加子菜单",
                    destroy: "删除",
                    excel: "导出excel",
                    pdf: "导出pdf",
                    loading: "数据加载中",
                    retry: "重试",
                    noRows: "没有可用记录",
                    requestFailed: "数据加载失败"
                }
            }
        },

        editor: {
            userEditor: userEditor,
            deptEditor: deptEditor,
            postEditor: postEditor,
            rankEditor: rankEditor,
            passwordEditor: passwordEditor,
            dateEditor: dateEditor,
            dateTimeEditor: dateTimeEditor
        }
    };

    return obj;

    function dateTimeEditor(container, options) {
        $('<input/>').attr('name', options.field).appendTo(container)
            .kendoDateTimePicker({
                format: 'yyyy-MM-dd hh:mm tt'
            });
    }

    function dateEditor(container, options) {
        var model = options.model,
            value = model.get(options.field),
            isNew = model.isNew(),
            format = options.format;

        $('<input/>').attr('name', options.field).appendTo(container)
            .kendoDatePicker({
                    format: format,
                    value: value,
                    disableDates: function (date) {
                        //console.log(isNew, date);
                        if (date) {
                            //console.log(new Date().getTime(), date.getTime(), new Date().getTime() - date.getTime());
                            return Math.round((new Date().getTime() - date.getTime()) / 86400 * 1000) >= 8640;
                        }
                        return false;
                    }
                }
            );
    }

    //密码编辑器
    function passwordEditor(container, options) {
        var
            field = options.field,
            value,
            editDom;

        value = options.model.get(field);//获取单元格的值(包含默认值)
        editDom = $("<input type='password'/>");
        editDom.attr("name", field);
        editDom.addClass("k-textbox");
        editDom.val(value);

        editDom.appendTo(container);
    }

    //人员下拉框编辑器
    function userEditor(container, options) {
        var
            field = options.field,
            validation,
            required,
            dataSource,
            editDom;

        if (field) {
            validation = options.model.fields[field].validation;
        } else {
            return;
        }

        //DATASOURCE
        dataSource = new kendo.data.DataSource({
            transport: {
                read: {
                    type: "GET",
                    url: root + "/common/users",
                    dataType: "json"
                }
            }
        });

        //VALIDATION
        if (validation && validation.hasOwnProperty("required")) {
            required = validation.required;
        }

        editDom = required ? "<input name='" + field + "' required/>" : "<input name='" + field + "'>";

        $(editDom).appendTo(container).kendoDropDownList({
            autoWidth: true,
            autoBind: true,
            delay: 1000,
            dataValueField: "id",
            dataTextField: "identicalName",
            text: "",
            value: null,
            optionsLabel: {id: null, identicalName: "请选择人员"},
            dataSource: dataSource,
            filter: "contains"
        }).data("kendoDropDownList");
    }

    //部门下拉框编辑器
    function deptEditor(container, options) {
        var
            field = options.field,
            validation,
            required,
            optionsLabel,
            dataSource,
            template,
            editDom,
            editor;

        if (field) {
            validation = options.model.fields[field].validation;
        } else {
            return;
        }

        //DATASOURCE
        dataSource = new kendo.data.DataSource({
            transport: {
                read: {
                    type: "GET",
                    url: root + "/common/depts",
                    dataType: "json"
                }
            }
        });
        template = "<span>#=name#</span>";
        optionsLabel = {id: null, name: "请选择部门"};

        //VALIDATION
        if (validation && validation.hasOwnProperty("required")) {
            required = validation.required;
        }
        if (required) {
            editDom = "<input name='" + field + "' required/>";
        } else {
            editDom = "<input name='" + field + "'>";
        }

        //INIT DROP DOWN LIST EDITOR
        editor = $(editDom).appendTo(container).kendoDropDownList({
            autoWidth: true,
            autoBind: true,
            delay: 1000,
            dataValueField: "id",
            dataTextField: "name",
            text: "",
            value: null,
            optionsLabel: optionsLabel,
            dataSource: dataSource,
            template: template,
            filter: "contains"
        }).data("kendoDropDownList");

        //SUBSCRIBE EVENTS
        editor.bind("change", function () {
            console.log("you select the dept item");
        });
    }

    //岗位下拉框编辑器
    function postEditor(container, options) {
        var
            field = options.field,
            validation,
            required,
            dataSource,
            editDom,
            editor;

        if (field) {
            validation = options.model.fields[field].validation;
        } else {
            return;
        }

        //DATASOURCE
        dataSource = new kendo.data.DataSource({
            transport: {
                read: {
                    type: "GET",
                    url: root + "/common/posts",
                    dataType: "json"
                }
            }
        });
        //VALIDATION
        if (validation && validation.hasOwnProperty("required")) {
            required = validation.required;
        }
        if (required) {
            editDom = "<input name='" + field + "' required/>";
        } else {
            editDom = "<input name='" + field + "'>";
        }

        //INIT DROP DOWN LIST EDITOR
        editor = $(editDom).appendTo(container).kendoDropDownList({
            autoWidth: true,
            autoBind: true,
            delay: 1000,
            dataValueField: "id",
            dataTextField: "name",
            text: "",
            value: null,
            optionsLabel: {id: null, name: "请选择岗位"},
            dataSource: dataSource,
            template: '<span>#=name#</span>',
            filter: "contains"
        }).data("kendoDropDownList");

        //SUBSCRIBE EVENTS
        editor.bind("change", function () {
            console.log("you select the GET item");
        });
    }

    //岗位等级下拉框编辑器
    function rankEditor(container, options) {
        var
            field = options.field,
            validation,
            required,
            dataSource,
            editDom;

        if (field) {
            validation = options.model.fields[field].validation;
        } else {
            return;
        }

        //DATASOURCE
        dataSource = new kendo.data.DataSource({
            transport: {
                read: {
                    type: "GET",
                    url: root + "/sysmgr/rank/data",
                    dataType: "json"
                }
            }
        });

        //VALIDATION
        if (validation && validation.hasOwnProperty("required")) {
            required = validation.required;
        }
        if (required) {
            editDom = "<input name='" + field + "' required/>";
        } else {
            editDom = "<input name='" + field + "'>";
        }

        //INIT DROP DOWN LIST EDITOR
        $(editDom).appendTo(container).kendoDropDownList({
            autoWidth: true,
            autoBind: true,
            delay: 1000,
            dataValueField: "id",
            dataTextField: "name",
            text: "",
            value: null,
            optionsLabel: {id: null, name: "请选择岗位等级"},
            dataSource: dataSource,
            template: '<span>#= name #</span>',
            filter: "contains"
        });
    }
})(jQuery);