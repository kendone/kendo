var core = (function () {
    var $mainTabstrip,//主内容展现区 jQuery 对象
        mainTabstrip,//主内容展现区KendoUI对象
        $asideMenu,//顶级导航菜单jQuery对象
        asideMenu,//顶级导航菜单KendoUI对象
        $firstMenu,//一级导航菜单jQuery对象
        firstMenu,//一级导航菜单KendoUI对象
        $secondMenu,//二级导航菜单jQuery对象
        secondMenu,//二级导航菜单KendoUI对象
        $thirdMenu,//三级导航菜单jQuery对象
        thirdMenu,//三级导航菜单KendoUI对象
        menuDs,//导航菜单数据源对象
        firstMenuData = [],//一级导航菜单数据源对象
        secondMenuData = [],//二级导航菜单数据源对象
        thirdMenuData = [],//三级导航菜单数据源对象

        //SPLITTER
        $outerSplitter,
        outerSplitter,
        $innerSplitter,
        innerSplitter,
        $menuSplitter,
        menuSplitter,

        //MENU
        $topLeftMenu,
        topLeftMenu,
        $topRightMenu,
        topRightMenu;

    $mainTabstrip = $("#main-tabstrip");
    $topLeftMenu = $("#top-left-menu");
    $topRightMenu = $("#top-right-menu");
    $asideMenu = $("#aside-menu");
    $firstMenu = $("#first-menu");
    $secondMenu = $("#second-menu");
    $thirdMenu = $("#third-menu");

    $outerSplitter = $("#outer-splitter");
    $innerSplitter = $("#inner-splitter");
    $menuSplitter = $("#menu-splitter");

    menuDs = function (options) {
        if (!options.menuId) return;

        $.ajax({
            type: "post",
            url: root + "/menu/navigation-menus",
            data: {menuId: options.menuId},
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            success: function (response) {
                options.success(response.items);//将顶级菜单对应的子孙节点数据回传给相应的处理方法
            }
        });
    };

    function _layout() {
        //OUTER SPLITTER
        $outerSplitter.kendoSplitter({
            orientation: "vertical",
            panes: [
                {collapsed: false, collapsible: false, scrollable: false, resizable: false, size: '32px'},
                {resizable: false, collapsible: false, scrollable: false},
                {resizable: false, collapsed: true, collapsible: true, scrollable: false, size: '200px'}
            ]
        });
        //INNER SPLITTER
        $innerSplitter.kendoSplitter({
            orientation: "horizontal",
            panes: [
                {collapsed: false, collapsible: true, scrollable: false, resizable: false, size: '80px'},
                {resizable: false, scrollable: false},
                {resizable: true, collapsed: true, collapsible: true, scrollable: false, size: '200px'}
            ]
        });
        //NAVIGATION SPLITTER
        $menuSplitter.kendoSplitter({
            orientation: "horizontal",
            panes: [
                {collapsed: false, collapsible: false, scrollable: false, resizable: false, size: '400px'},
                {collapsed: false, resizable: false, scrollable: false, size: '400px'},
                {resizable: false, collapsed: false, collapsible: false, scrollable: false}
            ]
        });

        //TOP CONTAINER MENU
        $topLeftMenu.kendoMenu({
            orientation: "horizontal"
        });
        $topRightMenu.kendoMenu({
            orientation: "horizontal",
            openOnClick: false
        });
        //ASIDE MENU
        $asideMenu.kendoMenu({
            orientation: "vertical"
        });
        //NAVIGATION MENU
        $firstMenu.kendoMenu({
            orientation: "vertical"
        });
        $secondMenu.kendoMenu({
            orientation: "vertical"
        });
        $thirdMenu.kendoMenu({
            orientation: "vertical"
        });

        //MAIN TABSTRIP
        $mainTabstrip.kendoTabStrip({
            animation: {
                open: {
                    effects: "fade"
                }
            }
        });

        mainTabstrip = $mainTabstrip.data("kendoTabStrip");
        outerSplitter = $outerSplitter.data("kendoSplitter");
        innerSplitter = $innerSplitter.data("kendoSplitter");
        menuSplitter = $menuSplitter.data("kendoSplitter");
        asideMenu = $asideMenu.data("kendoMenu");
        firstMenu = $firstMenu.data("kendoMenu");
        secondMenu = $secondMenu.data("kendoMenu");
        thirdMenu = $thirdMenu.data("kendoMenu");
        topLeftMenu = $topLeftMenu.data("kendoMenu");
        topRightMenu = $topRightMenu.data("kendoMenu");
    }

    function _event() {
        //绑定tabstrip头部关闭按钮点击事件
        mainTabstrip.tabGroup.on("click", "[data-action='close']", function (e) {
            var item = $(e.target).closest(".k-item"),
                items = mainTabstrip.items(),
                length = items.length;

            e.preventDefault();
            e.stopPropagation();
            mainTabstrip.remove(item);
            //mainTabstrip.remove(item.index());
            if (length > 0 && item.hasClass('k-state-active')) {
                mainTabstrip.select(0);//关闭tabstrip后切换到导航
            }
        });

        //点击顶级菜时根据菜单id获取其子孙菜单数据并渲染一级菜单
        asideMenu.bind("select", function (e) {
            var menuId = e.item.dataset.id;//获取菜单id

            if (!!menuId) {
                mainTabstrip.select(0);
                //加载对应顶级菜单下的所有子孙菜单
                setTimeout(function () {
                    menuDs({
                        menuId: menuId,
                        success: function (data) {
                            var firstMenuView;
                            firstMenuData = _data(data);
                            firstMenuView = _view("first-menu-tmpl", firstMenuData);
                            _render($firstMenu, firstMenuView);
                            _onRender(firstMenu, {index: 0, fired: "aside"});
                        }
                    });
                }, 25);
            }
        });
        //LEFT MENU
        topLeftMenu.bind("select", function (e) {
            var $target = $(e.item),
                $i = $target.find("i");

            if ($target.data("action") === "toggle-menu") {
                $i.toggleClass(function () {
                    return $(this).hasClass("fa-toggle-off") ? "fa-toggle-on" : "fa-toggle-off";
                });
                innerSplitter.toggle("#left-region");
            }
        });
        //RIGHT MENU
        topRightMenu.bind("select", function (e) {
            var $target = $(e.item),
                action = $target.data("action");

            if (action === undefined) return;

            switch (action) {
                case "user-info": {
                    var win = $("<div></div>").kendoWindow({
                        title: "个人信息",
                        content: root + "/user/info",
                        modal: true,
                        animation: {open: {effects: 'fade:in'}},
                        resizable: false,
                        visible: false
                    }).data("kendoWindow");

                    win.bind('refresh', function () {
                        win.center();
                    });
                    win.bind("close", function () {
                        win.destroy();
                    });

                    win.open();
                    break;
                }
                default: {
                    kendo.alert("菜单配置错误");
                    break;
                }
            }
        });
        //选择一级菜单时根据菜单id渲染二级菜单
        firstMenu.bind("select", function (e) {
            //fired === "aside"意味着事件触发由用户点击顶级菜单传递而来,否则由用户点击当前菜单项目而触发
            var index = e.fired === "aside" ? e.index : e.item.dataset.itemsIndex,
                items = firstMenuData[index].items,
                secondMenuView;

            secondMenuData = _data(items);
            secondMenuView = _view("second-menu-tmpl", secondMenuData);
            _render($secondMenu, secondMenuView);
            _onRender(secondMenu, {index: 0, fired: "aside"})
        });
        //选择二级菜单时根据菜单id渲染三级菜单
        secondMenu.bind("select", function (e) {
            var index = e.fired === "aside" ? e.index : e.item.dataset.itemsIndex,
                items = secondMenuData[index].items,
                thirdMenuView;

            thirdMenuData = _dataWindow(items);
            thirdMenuView = _view("third-menu-tmpl", thirdMenuData);
            _render($thirdMenu, thirdMenuView);
        });
        //thirdMenu select事件,三级菜单使用到导航打开具体业务界面的需要缓存打开窗口的参数window
        thirdMenu.bind("select", function (e) {
            var $item = $(e.item),
                name = $item.data("window-name"),
                icon = $item.data("window-icon"),
                model = $item.data("window-model"),
                url = $item.data("window-url"),
                openedMenuId = $item.data("id"),
                contentUrl = [],
                text = [],
                count = mainTabstrip.items().length,
                item = $("#opened-menu-" + openedMenuId).closest(".k-item"),
                index = item.index();

            if (index !== -1) {//判断当前菜单是否已经在tabstrip中打开
                mainTabstrip.select(index);
                return;
            }

            if (!model || !url) {
                kendo.alert("配置错误,请联系管理员");
                return;
            }

            text.push("<i class='" + icon + "'></i>");
            text.push(name);
            text.push('<span data-action="close" id="opened-menu-' + openedMenuId + '" class="k-link"><span class="k-icon k-font-icon k-i-x"></span></span>');

            contentUrl.push(root);
            contentUrl.push(model);
            contentUrl.push(url);
            if (contentUrl.length > 0) {
                mainTabstrip.append({
                    encoded: false,
                    text: text.join(""),
                    contentUrl: contentUrl.join("/")
                }).select(count);//打开并选中新tabstrip
            }
        });
        //阻止用户按下F5刷新整个页面
        $(document).keydown(function () {
            if (event.keyCode === 116) {
                event.keyCode = 0;
                event.returnValue = false;
            }
        });
        //TOOLTIP
        $asideMenu.kendoTooltip({
            width: 90,
            position: "right",
            filter: "li"
        });
    }

    function _init() {
        mainTabstrip.select(0);//DEFAULT SELECT THE FIRST TAB
        var li = $asideMenu.find("li").get(0);//默认导航页面显示顶级菜单的第一个菜单的子孙菜单
        _onRender(asideMenu, {item: li});
    }

    function init() {
        _layout();
        _event();
        _init();
    }

    //将原始数组数据处理成适合菜单数组数据
    function _data(data) {
        var items = [];

        if (!Array.isArray(data) || data.length === 0) {
            throw new Error('data must not be null');
        }

        data.forEach(function (node, index) {
            items.push({
                id: node.id,
                name: node.name,
                icon: node.icon,
                index: index,
                items: node.items
            });
        });

        return items;
    }

    function _dataWindow(data) {
        var items = [];
        if (!Array.isArray(data) || data.length === 0) {
            throw new Error('data must not be null');
        }

        data.forEach(function (node, index) {
            items.push({
                id: node.id,
                name: node.name,
                icon: node.icon,
                index: index,
                id_: node.id_,
                name_: node.name_,
                icon_: node.icon_,
                model_: node.model_,
                url_: node.url_
            });
        });

        return items;
    }

    //根据模版生成Kendo视图对象
    function _view(template, model) {
        return new kendo.View(template, {
            evalTemplate: true,
            model: model,
            wrap: false
        });
    }

    //根据菜单对象、Kendo视图和菜单配置生成菜单,默认菜单按照Y轴布局
    function _render($menu, view, options) {
        var html = view.render();
        options = options || {orientation: "vertical"};

        $menu.html(html).kendoMenu(options);
    }

    //菜单生成后触发相应事件,默认触发菜单的select事件
    function _onRender(menu, data, eventName) {
        eventName = eventName || "select";
        menu.trigger(eventName, data);
    }

    return {
        init: init,
        mainTabstrip: $mainTabstrip.data("kendoTabStrip")
    };
})();