<#assign base=request.contextPath />
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>后台管理平台</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="author"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet"
          type="text/css"/>
    <link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="system/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"
          type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css"/>
    <link href="assets/global/css/plugins.min.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN THEME LAYOUT STYLES -->
    <link href="assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css"
          id="style_color"/>
    <link href="assets/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME LAYOUT STYLES -->
    <link rel="shortcut icon" href="favicon.ico"/>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
<div class="page-wrapper">
    <!-- BEGIN HEADER -->
    <div class="page-header navbar navbar-fixed-top">
        <!-- BEGIN HEADER INNER -->
        <div class="page-header-inner ">
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="page-container">
        <!-- BEGIN SIDEBAR -->
        <div class="page-sidebar-wrapper">
            <!-- BEGIN SIDEBAR -->
            <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
            <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
            <div class="page-sidebar navbar-collapse collapse">
                <!-- BEGIN SIDEBAR MENU -->
                <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
                <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
                <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
                <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
                <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
                <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
                <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
                    <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                    <li class="sidebar-toggler-wrapper hide">
                        <div class="sidebar-toggler">
                            <span></span>
                        </div>
                    </li>
                    <!-- END SIDEBAR TOGGLER BUTTON -->
                    <!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
                    <li class="sidebar-search-wrapper">
                        <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
                        <!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
                        <!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
                        <form class="sidebar-search  " action="page_general_search_3.html" method="POST">
                            <a href="javascript:;" class="remove">
                                <i class="icon-close"></i>
                            </a>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                            <a href="javascript:;" class="btn submit">
                                                <i class="icon-magnifier"></i>
                                            </a>
                                        </span>
                            </div>
                        </form>
                        <!-- END RESPONSIVE QUICK SEARCH FORM -->
                    </li>

                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-basket"></i>
                            <span class="title">eCommerce</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="ecommerce_index.html" class="nav-link ">
                                    <i class="icon-home"></i>
                                    <span class="title">Dashboard</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="ecommerce_orders.html" class="nav-link ">
                                    <i class="icon-basket"></i>
                                    <span class="title">Orders</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="ecommerce_orders_view.html" class="nav-link ">
                                    <i class="icon-tag"></i>
                                    <span class="title">Order View</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="ecommerce_products.html" class="nav-link ">
                                    <i class="icon-graph"></i>
                                    <span class="title">Products</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="ecommerce_products_edit.html" class="nav-link ">
                                    <i class="icon-graph"></i>
                                    <span class="title">Product Edit</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-docs"></i>
                            <span class="title">Apps</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="app_todo.html" class="nav-link ">
                                    <i class="icon-clock"></i>
                                    <span class="title">Todo 1</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="app_todo_2.html" class="nav-link ">
                                    <i class="icon-check"></i>
                                    <span class="title">Todo 2</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="app_inbox.html" class="nav-link ">
                                    <i class="icon-envelope"></i>
                                    <span class="title">Inbox</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="app_calendar.html" class="nav-link ">
                                    <i class="icon-calendar"></i>
                                    <span class="title">Calendar</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="app_ticket.html" class="nav-link ">
                                    <i class="icon-notebook"></i>
                                    <span class="title">Support</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-user"></i>
                            <span class="title">User</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="page_user_profile_1.html" class="nav-link ">
                                    <i class="icon-user"></i>
                                    <span class="title">Profile 1</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_user_profile_1_account.html" class="nav-link ">
                                    <i class="icon-user-female"></i>
                                    <span class="title">Profile 1 Account</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_user_profile_1_help.html" class="nav-link ">
                                    <i class="icon-user-following"></i>
                                    <span class="title">Profile 1 Help</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_user_profile_2.html" class="nav-link ">
                                    <i class="icon-users"></i>
                                    <span class="title">Profile 2</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="icon-notebook"></i>
                                    <span class="title">Login</span>
                                    <span class="arrow"></span>
                                </a>
                                <ul class="sub-menu">
                                    <li class="nav-item ">
                                        <a href="page_user_login_1.html" class="nav-link " target="_blank"> Login Page 1 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_user_login_2.html" class="nav-link " target="_blank"> Login Page 2 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_user_login_3.html" class="nav-link " target="_blank"> Login Page 3 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_user_login_4.html" class="nav-link " target="_blank"> Login Page 4 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_user_login_5.html" class="nav-link " target="_blank"> Login Page 5 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_user_login_6.html" class="nav-link " target="_blank"> Login Page 6 </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_user_lock_1.html" class="nav-link " target="_blank">
                                    <i class="icon-lock"></i>
                                    <span class="title">Lock Screen 1</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_user_lock_2.html" class="nav-link " target="_blank">
                                    <i class="icon-lock-open"></i>
                                    <span class="title">Lock Screen 2</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-social-dribbble"></i>
                            <span class="title">General</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="page_general_about.html" class="nav-link ">
                                    <i class="icon-info"></i>
                                    <span class="title">About</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_general_contact.html" class="nav-link ">
                                    <i class="icon-call-end"></i>
                                    <span class="title">Contact</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="icon-notebook"></i>
                                    <span class="title">Portfolio</span>
                                    <span class="arrow"></span>
                                </a>
                                <ul class="sub-menu">
                                    <li class="nav-item ">
                                        <a href="page_general_portfolio_1.html" class="nav-link "> Portfolio 1 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_general_portfolio_2.html" class="nav-link "> Portfolio 2 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_general_portfolio_3.html" class="nav-link "> Portfolio 3 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_general_portfolio_4.html" class="nav-link "> Portfolio 4 </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item  ">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="icon-magnifier"></i>
                                    <span class="title">Search</span>
                                    <span class="arrow"></span>
                                </a>
                                <ul class="sub-menu">
                                    <li class="nav-item ">
                                        <a href="page_general_search.html" class="nav-link "> Search 1 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_general_search_2.html" class="nav-link "> Search 2 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_general_search_3.html" class="nav-link "> Search 3 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_general_search_4.html" class="nav-link "> Search 4 </a>
                                    </li>
                                    <li class="nav-item ">
                                        <a href="page_general_search_5.html" class="nav-link "> Search 5 </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_general_pricing.html" class="nav-link ">
                                    <i class="icon-tag"></i>
                                    <span class="title">Pricing</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_general_pricing_2.html" class="nav-link ">
                                    <i class="icon-tag"></i>
                                    <span class="title">Pricing 2</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_general_faq.html" class="nav-link ">
                                    <i class="icon-wrench"></i>
                                    <span class="title">FAQ</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_general_blog.html" class="nav-link ">
                                    <i class="icon-pencil"></i>
                                    <span class="title">Blog</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_general_blog_post.html" class="nav-link ">
                                    <i class="icon-note"></i>
                                    <span class="title">Blog Post</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_general_invoice.html" class="nav-link ">
                                    <i class="icon-envelope"></i>
                                    <span class="title">Invoice</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_general_invoice_2.html" class="nav-link ">
                                    <i class="icon-envelope"></i>
                                    <span class="title">Invoice 2</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-settings"></i>
                            <span class="title">System</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="page_cookie_consent_1.html" class="nav-link ">
                                    <span class="title">Cookie Consent 1</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_cookie_consent_2.html" class="nav-link ">
                                    <span class="title">Cookie Consent 2</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_system_coming_soon.html" class="nav-link " target="_blank">
                                    <span class="title">Coming Soon</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_system_404_1.html" class="nav-link ">
                                    <span class="title">404 Page 1</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_system_404_2.html" class="nav-link " target="_blank">
                                    <span class="title">404 Page 2</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_system_404_3.html" class="nav-link " target="_blank">
                                    <span class="title">404 Page 3</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_system_500_1.html" class="nav-link ">
                                    <span class="title">500 Page 1</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="page_system_500_2.html" class="nav-link " target="_blank">
                                    <span class="title">500 Page 2</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-folder"></i>
                            <span class="title">Multi Level Menu</span>
                            <span class="arrow "></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="icon-settings"></i> Item 1
                                    <span class="arrow"></span>
                                </a>
                                <ul class="sub-menu">
                                    <li class="nav-item">
                                        <a href="javascript:;" target="_blank" class="nav-link">
                                            <i class="icon-user"></i> Arrow Toggle
                                            <span class="arrow nav-toggle"></span>
                                        </a>
                                        <ul class="sub-menu">
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">
                                                    <i class="icon-power"></i> Sample Link 1</a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">
                                                    <i class="icon-paper-plane"></i> Sample Link 1</a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="#" class="nav-link">
                                                    <i class="icon-star"></i> Sample Link 1</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="icon-camera"></i> Sample Link 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="icon-link"></i> Sample Link 2</a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="icon-pointer"></i> Sample Link 3</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a href="javascript:;" target="_blank" class="nav-link">
                                    <i class="icon-globe"></i> Arrow Toggle
                                    <span class="arrow nav-toggle"></span>
                                </a>
                                <ul class="sub-menu">
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="icon-tag"></i> Sample Link 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="icon-pencil"></i> Sample Link 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="icon-graph"></i> Sample Link 1</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="icon-bar-chart"></i> Item 3 </a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- END SIDEBAR MENU -->
                <!-- END SIDEBAR MENU -->
            </div>
            <!-- END SIDEBAR -->
        </div>
        <!-- END SIDEBAR -->
        <!-- BEGIN CONTENT -->
        <div class="page-content-wrapper">
            <!-- BEGIN CONTENT BODY -->
            <div class="page-content" style="min-height: 1150px;">
                <!-- BEGIN PAGE HEADER-->
                <!-- BEGIN THEME PANEL -->
                <div class="theme-panel hidden-xs hidden-sm">
                    <div class="toggler"> </div>
                    <div class="toggler-close"> </div>
                    <div class="theme-options">
                        <div class="theme-option theme-colors clearfix">
                            <span> THEME COLOR </span>
                            <ul>
                                <li class="color-default current tooltips" data-style="default" data-container="body" data-original-title="Default"> </li>
                                <li class="color-darkblue tooltips" data-style="darkblue" data-container="body" data-original-title="Dark Blue"> </li>
                                <li class="color-blue tooltips" data-style="blue" data-container="body" data-original-title="Blue"> </li>
                                <li class="color-grey tooltips" data-style="grey" data-container="body" data-original-title="Grey"> </li>
                                <li class="color-light tooltips" data-style="light" data-container="body" data-original-title="Light"> </li>
                                <li class="color-light2 tooltips" data-style="light2" data-container="body" data-html="true" data-original-title="Light 2"> </li>
                            </ul>
                        </div>
                        <div class="theme-option">
                            <span> Theme Style </span>
                            <select class="layout-style-option form-control input-sm">
                                <option value="square" selected="selected">Square corners</option>
                                <option value="rounded">Rounded corners</option>
                            </select>
                        </div>
                        <div class="theme-option">
                            <span> Layout </span>
                            <select class="layout-option form-control input-sm">
                                <option value="fluid" selected="selected">Fluid</option>
                                <option value="boxed">Boxed</option>
                            </select>
                        </div>
                        <div class="theme-option">
                            <span> Header </span>
                            <select class="page-header-option form-control input-sm">
                                <option value="fixed" selected="selected">Fixed</option>
                                <option value="default">Default</option>
                            </select>
                        </div>
                        <div class="theme-option">
                            <span> Top Menu Dropdown</span>
                            <select class="page-header-top-dropdown-style-option form-control input-sm">
                                <option value="light" selected="selected">Light</option>
                                <option value="dark">Dark</option>
                            </select>
                        </div>
                        <div class="theme-option">
                            <span> Sidebar Mode</span>
                            <select class="sidebar-option form-control input-sm">
                                <option value="fixed">Fixed</option>
                                <option value="default" selected="selected">Default</option>
                            </select>
                        </div>
                        <div class="theme-option">
                            <span> Sidebar Menu </span>
                            <select class="sidebar-menu-option form-control input-sm">
                                <option value="accordion" selected="selected">Accordion</option>
                                <option value="hover">Hover</option>
                            </select>
                        </div>
                        <div class="theme-option">
                            <span> Sidebar Style </span>
                            <select class="sidebar-style-option form-control input-sm">
                                <option value="default" selected="selected">Default</option>
                                <option value="light">Light</option>
                            </select>
                        </div>
                        <div class="theme-option">
                            <span> Sidebar Position </span>
                            <select class="sidebar-pos-option form-control input-sm">
                                <option value="left" selected="selected">Left</option>
                                <option value="right">Right</option>
                            </select>
                        </div>
                        <div class="theme-option">
                            <span> Footer </span>
                            <select class="page-footer-option form-control input-sm">
                                <option value="fixed">Fixed</option>
                                <option value="default" selected="selected">Default</option>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- END THEME PANEL -->
                <!-- BEGIN PAGE BAR -->
                <div class="page-bar">
                    <ul class="page-breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                            <i class="fa fa-circle"></i>
                        </li>
                        <li>
                            <span>Tables</span>
                        </li>
                    </ul>
                    <div class="page-toolbar">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn green btn-sm btn-outline dropdown-toggle" data-toggle="dropdown"> Actions
                                <i class="fa fa-angle-down"></i>
                            </button>
                            <ul class="dropdown-menu pull-right" role="menu">
                                <li>
                                    <a href="#">
                                        <i class="icon-bell"></i> Action</a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="icon-shield"></i> Another action</a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="icon-user"></i> Something else here</a>
                                </li>
                                <li class="divider"> </li>
                                <li>
                                    <a href="#">
                                        <i class="icon-bag"></i> Separated link</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- END PAGE BAR -->
                <!-- BEGIN PAGE TITLE-->
                <h1 class="page-title"> Basic Bootstrap Tables
                    <small>basic bootstrap tables with various options and styles</small>
                </h1>
                <!-- END PAGE TITLE-->
            </div>
            <!-- END CONTENT BODY -->
        </div>
        <!-- END CONTENT -->
        <!-- BEGIN QUICK SIDEBAR -->
        <a href="javascript:;" class="page-quick-sidebar-toggler">
            <i class="icon-login"></i>
        </a>
        <!-- END QUICK SIDEBAR -->
    </div>
</div>