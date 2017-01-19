<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<%@include file="/WEB-INF/template/header.jsp"%>
	<title>产品信息披露</title>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<c:set var="resUrl" value="/product/sustain/notice/list" scope="page"/>
		<%@include file="/WEB-INF/template/navigation.jsp"%>

		<div class="content-wrapper">
			<section style="padding-top: 5px;">
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard marginR6"></i><a href="${pageContext.request.contextPath}/index">首页</a></li>
					<li><a  href="#">产品存续管理</a></li>
					<li class="active"><span class="act-style"><a href="${pageContext.request.contextPath}/product/sustain/notice/list">产品信息披露</a></span></li>
				</ol>
			</section>
			
			
			  <!-- START CUSTOM TABS -->
            <div class="row">
                <div style="margin-left: 15px;margin-right: 10px;" class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                             <li class="active"><a href="#tab_1" data-toggle="tab">信息披露列表</a></li>
                         	<li><a href="#tab_2" data-toggle="tab">信息披露提醒</a></li>
                            <!-- <li><a href="#tab_3" data-toggle="tab">附件管理</a></li> -->
                        </ul>
                        <div class="tab-content">
                            <!-- 信息披露列表-->
                            <div class="tab-pane active" id="tab_1">
                        	  <section class="content-search-area">
					            <form id="noticeQuery" method="post">
					                <div class="user-search">
					                    <div class="row form-horizontal" id="search-form">
					                        <div class="row" style="padding:0 30px 0 15px;">
					                            <div class="col-md-3 paddingLR0" style='padding-left:0px;'>
					                                <div class="form-group">
					                                    <label class="col-sm-4 control-label form-label paddingR0 paddingL0">产品名称</label>
					                                    <div class="col-sm-8 paddingR0">
					                                        <input type="text" class="form-control input-sm" name="productName" id="productName" placeholder="产品名称">
					                                    </div>
					                                </div>
					                            </div>
					                            <div class="col-md-3 paddingLR0">
					                                <div class="form-group">
					                                    <label class="col-sm-4 control-label form-label paddingR0 paddingL0">披露类型</label>
					                                    <div class="col-sm-8 paddingR0">
					                                   		 <select class="form-control select2" style="width:100%;" name="noticeType" id="noticeType">
															</select>
					                                    </div>
					                                </div>
					                            </div>
					                       
						                         <div class="col-md-3 paddingLR0" style='padding-left:0px;'>
						                                <div class="form-group">
						                                    <label class="col-sm-4 control-label form-label paddingR0 paddingL0"></label>
						                                    <div class="col-sm-8 paddingR0">
						                                        <button type="button" class="btn btn-primary searchBtn" id="searchBtn"><i
									                                    class="fa fa-search marginR6"></i>搜索
									                            </button>
						                                    </div>
						                                </div>
						                          </div>
					                        </div>
					                        
					                    </div>
					                </div>
					            </form>
					        	</section>
					        	<section class="main-bootstrap-table">
					    		<div class="in-table">
					    		<div class="btns">
					    			<shiro:hasPermission name="sustain_notice:add">
										<a href='${pageContext.request.contextPath}/product/sustain/notice/add' class="btn btn-primary btn-style">
											<i class="fa fa-plus marginR6"></i>新增
										</a>
									</shiro:hasPermission>
									<shiro:hasPermission name="sustain_notice:edit">
										<button type="button" id="editBtn" class="btn btn-primary btn-style"><i class="fa fa-edit marginR6"></i>修改</button>
									</shiro:hasPermission>
									<shiro:hasPermission name="sustain_notice:delete">
										<button type="button" id="deleteBtn" class="btn btn-primary btn-style"><i class="fa fa-remove marginR6"></i>删除</button>
									</shiro:hasPermission>
					    		</div>
							    <table id="noticeList" class="table table-hover">
							        <thead>
								        <tr>
								            <th data-radio="true"></th>
								            <th data-field="productName">产品名称</th>
											<th data-field="noticeType">披露类型</th>
											<th data-field="period">期数</th>
											<th data-field="noticeDate">披露日期</th>
											<th data-field="noticeDesc">描述</th>
											<th data-field="activeFlag">有效状态</th>
											<th data-field="createBy">创建人</th>
											<th data-field="createTime" data-sortable="true">创建时间</th>
								        </tr>
							        </thead>
							    </table>
							</div>
					    	</section> 		
        	
                            </div><!-- 披露列表END-->
                            
                            <!-- 提醒记录-->
                            <div class="tab-pane" id="tab_2">
                     			<section class="content-search-area">
					            <form id="noticeRemindQuery" method="post">
					                <div class="user-search">
					                    <div class="row form-horizontal" id="search-form">
					                        <div class="row" style="padding:0 30px 0 15px;">
					                            <div class="col-md-3 paddingLR0" style='padding-left:0px;'>
					                                <div class="form-group">
					                                    <label class="col-sm-4 control-label form-label paddingR0 paddingL0">产品名称</label>
					                                    <div class="col-sm-8 paddingR0">
					                                        <input type="text" class="form-control input-sm" name="productNameRemind" id="productNameRemind" placeholder="产品名称">
					                                    </div>
					                                </div>
					                            </div>
					                            <div class="col-md-3 paddingLR0">
					                                <div class="form-group">
					                                    <label class="col-sm-4 control-label form-label paddingR0 paddingL0">提醒类型</label>
					                                    <div class="col-sm-8 paddingR0">
					                                       <select class="form-control select2" style="width:100%;" name="remindType" id="remindType">
														   </select>
					                                    </div>
					                                </div>
					                            </div>
					                            <div class="col-md-3 paddingLR0" style='padding-left:0px;'>
						                                <div class="form-group">
						                                    <label class="col-sm-4 control-label form-label paddingR0 paddingL0"></label>
						                                    <div class="col-sm-8 paddingR0">
						                                        <button type="button" class="btn btn-primary searchBtn" id="searchBtnRemind"><i
									                                    class="fa fa-search marginR6"></i>搜索
									                            </button>
						                                    </div>
						                                </div>
						                          </div>
					                          </div>
					                    </div>
					                </div>
					            </form>
					        	</section>
					        	 <section class="main-bootstrap-table">
						    		<div class="in-table">
						    		<div class="btns">
						    			<shiro:hasPermission name="sustain_notice:remindadd">
											<a href='${pageContext.request.contextPath}/product/sustain/noticeRemind/remindAdd' class="btn btn-primary btn-style">
												<i class="fa fa-plus marginR6"></i>新增
											</a>
										</shiro:hasPermission>
										<shiro:hasPermission name="sustain_notice:remindedit">
											<button type="button" id="editBtnRemind" class="btn btn-primary btn-style"><i class="fa fa-edit marginR6"></i>修改</button>
										</shiro:hasPermission>
										<shiro:hasPermission name="sustain_notice:reminddelete">
											<button type="button" id="deleteBtnRemind" class="btn btn-primary btn-style"><i class="fa fa-remove marginR6"></i>删除</button>
										</shiro:hasPermission>
					    		   </div>
								    <table id="remindList" class="table table-hover">
								        <thead>
									        <tr>
									            <th data-radio="true"></th>
									            <th data-field="productName">产品名称</th>
												<th data-field="remindType">提醒类型</th>
												<th data-field="remindDate">提醒日</th>
												<th data-field="remindDesc">描述</th>
												<th data-field="applyBy">创建人人</th>
												<th data-field="applyDate" data-sortable="true">创建时间</th>
									        </tr>
								        </thead>
								    </table>
									</div>
						    	</section> 	
        	
                            </div><!-- 提醒记录END-->
                            
                            <!-- 附件记录-->
                           <%--  <div class="tab-pane" id="tab_3">
                     			<section class="content-search-area">
					            <form id="noticeFileQuery" method="post">
					                <div class="user-search">
					                    <div class="row form-horizontal" id="search-form">
					                        <div class="row" style="padding:0 30px 0 15px;">
					                            <div class="col-md-3 paddingLR0" style='padding-left:0px;'>
					                                <div class="form-group">
					                                    <label class="col-sm-4 control-label form-label paddingR0 paddingL0">产品名称</label>
					                                    <div class="col-sm-8 paddingR0">
					                                        <input type="text" class="form-control input-sm" name="productNameFile" id="productNameFile" placeholder="产品名称">
					                                    </div>
					                                </div>
					                            </div>
					                            <div class="col-md-3 paddingLR0">
					                                <div class="form-group">
					                                    <label class="col-sm-4 control-label form-label paddingR0 paddingL0">文件类型</label>
					                                    <div class="col-sm-8 paddingR0">
					                                       <select class="form-control select2" style="width:100%;" name="fileType" id="fileType">
														   </select>
					                                    </div>
					                                </div>
					                            </div>
					                            <div class="col-md-3 paddingLR0" style='padding-left:0px;'>
						                                <div class="form-group">
						                                    <label class="col-sm-4 control-label form-label paddingR0 paddingL0"></label>
						                                    <div class="col-sm-8 paddingR0">
						                                        <button type="button" class="btn btn-primary searchBtn" id="searchBtnFile"><i
									                                    class="fa fa-search marginR6"></i>搜索
									                            </button>
						                                    </div>
						                                </div>
						                          </div>
					                          </div>
					                    </div>
					                </div>
					            </form>
					        	</section>
					        	 <section class="main-bootstrap-table">
						    		<div class="in-table">
						    		<div class="btns">
						    			<shiro:hasPermission name="sustain_notice:fileadd">
											<a href='${pageContext.request.contextPath}/product/sustain/notice/add' class="btn btn-primary btn-style">
												<i class="fa fa-plus marginR6"></i>新增
											</a>
										</shiro:hasPermission>
										<shiro:hasPermission name="sustain_notice:fileedit">
											<button type="button" id="editBtnFile" class="btn btn-primary btn-style"><i class="fa fa-edit marginR6"></i>修改</button>
										</shiro:hasPermission>
										<shiro:hasPermission name="sustain_notice:filedelete">
											<button type="button" id="deleteBtnFile" class="btn btn-primary btn-style"><i class="fa fa-remove marginR6"></i>删除</button>
										</shiro:hasPermission>
					    		   </div>
								    <table id="projectVoteHisList" class="table table-hover">
								        <thead>
									        <tr>
									            <th data-radio="true"></th>
									            <th data-field="productName">产品名称</th>
									            <th data-field="oldFileName">文件名</th>
												<th data-field="type">文件类型</th>
												<th data-field="createBy">上传人</th>
												<th data-field="createTime" data-sortable="true">上传时间</th>
									        </tr>
								        </thead>
								    </table>
									</div>
						    	</section> 	
        	
                            </div> --%><!-- 附件END-->
                        </div>
                    </div>
                    <!-- nav-tabs-custom -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
            <!-- END CUSTOM TABS -->
			
			

		    
		    
		</div>
		<%@include file="/WEB-INF/template/footer.jsp" %>
	</div>
	<%@include file="/WEB-INF/template/scripts.jsp" %>
	<script type="text/javascript">
	$(function() {
		initDefaultSelect('#activeFlag', basePath + "/cache/valueset/PRD_ACTIVE_FLAG?addSelect=true", "", "请选择");
		initDefaultSelect('#noticeType', basePath + "/cache/valueset/PRD_NOTICE_TYPE?addSelect=true", "", "请选择");
		//initDefaultSelect('#remindType', basePath + "/cache/valueset/REMIND_TYPE?addSelect=true", "", "请选择");
		//initDefaultSelect('#fileType', basePath + "/cache/valueset/PRD_TYPE?addSelect=true", "", "请选择");

		loadGrid('#noticeList', '/product/sustain/notice/list.json', '#noticeQuery', {
            singleSelect: true,
            sortName: "",
            sortOrder: "",
            onDblClickRow: function(row, $el){
                //openModal(basePath + "/product/sustain/notice/view?id=" + row.id + "&passKey=" + row.passKey);
            }
        });

		$('#searchBtn').click(function() {
			searchGrid('#noticeList');
		});
		
		$('#editBtn').click(function() {
	            if (!isSelect('#noticeList')) {return false;};
	            var row = $('#noticeList').bootstrapTable('getSelections')[0];
	            var url = basePath + "/product/sustain/notice/edit?id="+row.id + "&passKey=" + row.passKey;
	            window.location.href = url;
        });
		
		 $('#deleteBtn').click(function() {
	            if (!isSelect('#noticeList')) {return false;};
	            var row = $('#noticeList').bootstrapTable('getSelections')[0];
	            var url = basePath + "/product/sustain/notice/delete?id=" + row.id + "&passKey=" + row.passKey;
	            confirmPost(url, "#noticeList", "您确定要删除该信息吗？");
	     })
	     
	     //提醒
	    /*  loadGrid('#noticeRemindList', '/product/sustain/noticeRemind/remindList.json', '#noticeRemindQuery', {
            singleSelect: true,
            sortName: "",
            sortOrder: "",
            onDblClickRow: function(row, $el){
            }
        });

		$('#searchBtnRemind').click(function() {
			searchGrid('#noticeRemindList');
		});
		
		$('#editBtnRemind').click(function() {
	            if (!isSelect('#noticeRemindList')) {return false;};
	            var row = $('#noticeRemindList').bootstrapTable('getSelections')[0];
	            var url = basePath + "/product/sustain/noticeRemind/edit?id="+row.id + "&passKey=" + row.passKey;
	            window.location.href = url;
        });
		
		 $('#deleteBtnRemind').click(function() {
	            if (!isSelect('#noticeRemindList')) {return false;};
	            var row = $('#noticeRemindList').bootstrapTable('getSelections')[0];
	            var url = basePath + "/product/sustain/noticeRemind/deleteRemind?id=" + row.id + "&passKey=" + row.passKey;
	            confirmPost(url, "#noticeRemindList", "您确定要删除该信息吗？");
	     }) */
	    
	});
	</script>
</body>
</html>