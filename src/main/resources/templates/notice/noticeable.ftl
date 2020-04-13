<div class="bgc-w box box-primary">
	<!--盒子头-->
	<div class="box-header">
		<h3 class="box-title">
			<a href="noticeedit" class="label label-success"
				style="padding: 5px;"> <span class="glyphicon glyphicon-plus"></span>
				新增
			</a>
			<a href="" class="label label-success" style="padding: 5px;margin-left:5px;">
				<span class="glyphicon glyphicon-refresh"></span> 刷新
			</a>
		</h3>
		<div class="box-tools">
			<div class="input-group" style="width: 150px;">
				<input type="text" class="form-control input-sm baseKey" placeholder="按标题查找" value="${(baseKey)!''}"/>
				<div class="input-group-btn">
					<a class="btn btn-sm btn-default baseKetsubmit"><span
						class="glyphicon glyphicon-search"></span></a>
				</div>
			</div>
		</div>
	</div>
	<!--盒子身体-->
	<div class="box-body no-padding">
		<div class="table-responsive">
			<table class="table table-hover">
				<tr>
					<th scope="col"><span class="paixu thistype">类型
						<#if type?? && icon??>
						<span class="glyphicon ${icon}"></span>
						</#if>
						</span></th>

					<th scope="col">文章标题</th>
					<th scope="col"><span class="paixu thistime">发布时间
						<#if time?? && icon??>
							<span class="glyphicon ${icon}"></span>
						</#if>
						</span></th>
					<th scope="col">文章作者</th>
					<th scope="col">图片作者</th>

					<th scope="col">备注</th>
					<th scope="col">操作</th>
				</tr>
				<#list list as this>
				<tr>
					<td>${(this.typeName)!''}</td>
					<td><span>${(this.title)!''}</span></td>
					<td><span>${(this.creatTime)!''}</span></td>
					<td><span>${(this.contentAuthor)!''}</span></td>
					<td><span>${(this.imageAuthor)}</span></td>

					<td><span>${(this.notes)}</span></td>
					<td><a href="noticeedit?id=${this.noticeId}"
						class="label xiugai"><span class="glyphicon glyphicon-edit"></span>
							修改</a> 
							<a href="noticeshow?id=${this.noticeId}" class="label xiugai "><span
							class="glyphicon glyphicon-search"></span> 查看</a> 
							<a onclick="{return confirm('删除该记录将不能恢复，确定删除吗？');};"
						href="noticedelete?id=${this.noticeId}" class="label shanchu"><span
							class="glyphicon glyphicon-remove"></span> 删除</a></td> 
				</tr>
				</#list>
			</table>
		</div>
	</div>
	<!--盒子尾-->
	<#include "/common/paging.ftl"/>
</div>

<!-- <script type="text/javascript" src="js/common/sort.js" charset='utf-8'></script> -->