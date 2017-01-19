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
					<li><a href="${pageContext.request.contextPath}/product/sustain/notice/list">产品信息披露</a></li>
					<li class="active"><span class="act-style">编辑</span></li>
				</ol>
			</section>
		    <form id="editForm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/product/sustain/notice/${action}" method="post">
			<hyb:token/>
			<hyb:hidden name="id" value="${notice.id}"/>
			<hyb:hidden name="version" value="${notice.version}"/>
			<div class="modal-body" style="padding-bottom:0px;">
                    <div class="row form-horizontal">
                    		<div class="form-group">
								 <label for="productName" class="col-sm-2 control-label">产品名称</label>
							   	 <div class="col-md-8">
		                            <c:if test="${action=='create'}">
		                                <select class="form-control select2 inputStyle" name="productId" id="productId"
		                                        style="width: 100%;" data-bv-notempty></select>
		                            </c:if>
		                            <c:if test="${action=='update'}">
		                                 <span style="padding-top:100px;">${notice.productName}</span>
		                            </c:if>
		                        </div>
							 </div>
						
							<div class="form-group">
								 <label for="noticeType" class="col-sm-2 control-label">披露类型</label>
							   	  <div class="col-md-8">
		                                <select class="form-control select2 inputStyle" name="noticeType" id="noticeType"
		                                        style="width: 100%;"></select>
		                                <input type="hidden" name="notice_type" id="notice_type" value="${notice.noticeType}">        
								 </div>
							 </div>
						
							 <div class="form-group">
								 <label for="period" class="col-sm-2 control-label">期数</label>
							   	  <div class="col-sm-8" style=margin-top:5px;>
							   	  	<input type="text" class="form-control inputStyle" id="period" name="period" value="${notice.period }">
								 </div>
							 </div>
						
							<div class="form-group">
								<label for="noticeDate" class="col-sm-2 control-label form-label">披露日期</label>
								<div class="col-sm-8">
									<input type="text" class="form-control inputStyle datepicker" id="noticeDate" name="noticeDate" 
									value='<fmt:formatDate pattern="yyyy-MM-dd" value="${notice.noticeDate}"/>'>
								</div>
							</div>
							<div class="form-group">
							        <label class="col-md-2 control-label form-label">描述</label>
							        <div class="col-md-8">
										<textarea class="form-control inputStyle" rows="3"
							                                  name="noticeDesc" data-bv-stringlength
							                                  data-bv-stringlength-max="512">${notice.noticeDesc}</textarea>
							        </div>
						    </div>
						   
					</div>
					
         		</div>
				<div class="row t_c">
					<div class="form-group btn-group0">
						<button type="submit" id="submitBtn" class="btn btn-success">提交</button>
						<a class="btn btn-default marginL"
						   onclick="javascript:window.location.href='${pageContext.request.contextPath}/product/sustain/notice/list'">返回</a>
					</div>
			</div>
			</form>
			
		</div>
		<%@include file="/WEB-INF/template/footer.jsp" %>
	</div>
	<%@include file="/WEB-INF/template/scripts.jsp" %>
	<script type="text/javascript">
	$(function() {
        initDefaultSelect('#productId', basePath + "/product/sustain/opendate/getProductInfo?addSelect=false", '', "请选择产品");
		initDefaultSelect('#noticeType', basePath + "/cache/valueset/PRD_NOTICE_TYPE?addSelect=true",$("#notice_type").val(), "请选择");

		initVaildateSumitForm("#editForm", "#submitBtn", "${pageContext.request.contextPath}/product/sustain/notice/list");
	
	});

	</script>
</body>
</html>