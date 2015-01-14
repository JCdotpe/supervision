<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:simple>
    <jsp:attribute name="header">
    
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">OEFA</p>    
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.form.js"/>'></script>   
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listMatriz.js"/>'></script>   
    </jsp:attribute>
    
    <jsp:body>
		<span>Actividad</span>
		<h2>Matriz</h2>
		<br />
		<br />
		<ul class="nav nav-tabs" id="tabMatriz">
		<c:forEach items="${listMatrices}" var="matriz" varStatus="loopCounter">
			<c:if test="${loopCounter.count == 1}">
				<li class="active"><a href="#tab${loopCounter.count}">${matriz.nombrematriz}</a></li>
			</c:if>
			<c:if test="${loopCounter.count != 1}">
				<li><a href="#tab${loopCounter.count}">${matriz.nombrematriz}</a></li>
			</c:if>
		</c:forEach>
		</ul>
		<div class="tab-content">
			<c:forEach items="${listMatrizActividad}" var="matrizactividad" varStatus="loopCounter">
			
				<c:if test="${loopCounter.count == 1}">
					<div class="tab-pane active tab_matriz" id="tab${loopCounter.count}">
				</c:if>
				<c:if test="${loopCounter.count != 1}">
					<div class="tab-pane tab_matriz" id="tab${loopCounter.count}">
				</c:if>
				
					<table class="table uppertext ">
			  			<thead>
				  			<tr>
				  				<th colspan="6"><center>Matriz Supervisión</center></th>
				  			</tr>
				  			<tr>
				  				<th colspan="6">
				  					<div class="block_td">
						  				<div class="col_td col_funciones"></div>
						  				<div class="col_td col_item">Item</div>
						  				<div class="col_td col_descripcion">Descripción</div>
						  				<div class="col_td col_item">Sub Item</div>
						  				<div class="col_td col_descripcion">Descripción</div>
						  				<div class="col_td col_verificable">Verificable</div>
						  			</div>
					  			</th>
				  			</tr>
			  			</thead>
						<tbody>
						<c:forEach items="${listComponentes}" var="componente" varStatus="loopCounter2">
							<c:if test="${matrizactividad.idmatriz == componente.idmatriz}">
								<tr> 
									<td colspan="6">
					  					<div class="block_td">
											<div class="col_td col_funciones"><a href="#" class="btn btn_verFunciones">Funciones</a></div>
											<div class="col_td col_item"><center>${componente.item}</center></div>
											<div class="col_td col_descripcion">${componente.descripcioncomponente}</div>
											<div class="col_td col_item"><center>${componente.subitem}</center></div>
											<div class="col_td col_descripcion">${componente.descripcionsubitem}</div>
											<div class="col_td col_verificable"></div>
							  			</div>
						  			
					  					<div class="block_td block_td_bot">
					  						<table class="table uppertext table_funciones">
			  									<thead>
				  									<tr>
				  										<th width="200">Funciones</th>
				  										<th width="180">Indicadores</th>
				  										<th width="20"></th>
				  										<th>Observacion</th>
				  										<th width="180">Base legal</th>
				  										<th>Verificable</th>
				  										<th></th>
				  										<th width="90"></th>
				  									</tr>
				  								</thead>
				  								<tbody>
				  									<c:forEach items="${listFunciones}" var="funciones" varStatus="loopCounter3">
						  								<c:if test="${componente.idcomponente == funciones.idcomponente}">
						  									
							  									<tr>
							  										<td colspan="8">
							  											<c:url var="actionUrlMatriz2" value="/matriz/addIndicadoresbyFuncion" />
							  											
							  												<c:forEach items="${mListActividadFuncion}" var="actividadfuncion" varStatus="loopCounteras">
								 												<c:if test="${funciones.idfuncion == actividadfuncion.idfuncion}">
									  											<form id="frm_funcion_${loopCounter3.count}" method="post" action="${actionUrlMatriz2}">
										  											<table class="table uppertext">
										  												<tr>
													  										<td width="200">${funciones.descripcionfuncion}</td>
													  										<td width="200" colspan="2">
													  											<table  class="table" style="font-size: 9px">
													  												<c:forEach items="${mlistIndicadores}" var="indicadores" varStatus="loopCounter4">
													  													<c:if test="${funciones.idfuncion == indicadores.idfuncion}">
													  														<tr>
													  															<td>${indicadores.descripcionindicador}</td>
													  															<c:choose>
													  																<c:when test="${fn:length(mListActividadIndicador) gt 0}">
													  																	<c:set var="checked" value=""/>
													  																	<c:set var="disabled" value=""/>
															  															<c:forEach items="${mListActividadIndicador}" var="indicadorActividad"  varStatus="loopCounterindAct">
															  																
															  																<c:if test="${indicadores.idindicador == indicadorActividad.idindicador}">
																																<c:set var="checked" value="checked"/>
															  																</c:if>
																  															<c:if test="${actividadfuncion.idmatrizactividadfunciones == indicadorActividad.idmatrizactividadfunciones}">
																																<c:set var="disabled" value="disabled"/>
															  																</c:if>
															  															</c:forEach>
																  														<td valign="top"><input ${checked} ${disabled} type="checkbox" class="chk_indicador" value="${indicadores.idindicador}" name="chk_indicador" /></td>
															  														</c:when>
															  														<c:otherwise>
															  															<td valign="top"><input type="checkbox" class="chk_indicador" value="${indicadores.idindicador}" name="chk_indicador" /></td>
															  														</c:otherwise>
													  															</c:choose>
													  														</tr>
													  													</c:if>
													  												</c:forEach>
													  											</table>
													  										</td>
													  										<td width="114">
													  											<c:if test="${actividadfuncion.observaciones == null}"> 											
														  											<textarea class="txtaObservacion" name="txtaObservacion"></textarea>
												  												</c:if>
													  											
													  											<c:if test="${actividadfuncion.observaciones != ''}"> 											
														  											${actividadfuncion.observaciones}
												  												</c:if>
													  										</td>
													  										<td width="180">${funciones.baselegal}</td>
													  										<td width="104"></td>
													  										<td width="75"></td>
													  										<td width="90">
												  												<c:if test="${actividadfuncion.estadomatrizactividadfunciones == '0'}"> 											
														  											<input type="hidden" name="idmatrizactividad" value="${matrizactividad.idmatrizactividad}">
														  											<input type="hidden" name="idfuncion" value="${funciones.idfuncion}">
														  											<a href="#myModal" data-disabled="false" role="button" data-toggle="modal" 
														  												data-matrizactividad="${matrizactividad.idmatrizactividad}" 
														  												data-funcion="${funciones.idfuncion}" class="btn btnArchive">Archivos</a>
														  											<br /><br />
														  											<a href="#" class="btn btn_save_funcion " 
														  												data-pos="${loopCounter3.count}"
														  												data-matrizactividad="${matrizactividad.idmatrizactividad}" 
														  												data-funcion="${funciones.idfuncion}">Guardar</a>
												  												</c:if>
												  												<c:if test="${actividadfuncion.estadomatrizactividadfunciones != '0'}"> 
														  											<a href="#myModal" role="button" data-disabled="true" data-toggle="modal" 
														  												data-matrizactividad="${matrizactividad.idmatrizactividad}" 
														  												data-funcion="${funciones.idfuncion}" class="btn btnArchive">Archivos</a>
														  										</c:if>
													  										</td>
												  										</tr>
											  										</table>
										  										</form>
							  												</c:if>
							  											</c:forEach>
								  									</td>
							  									</tr>
						  									
						  								</c:if>
				  									</c:forEach>
				  								</tbody>
				  							</table>
					  						
							  			</div>
									</td>
								</tr>
							</c:if>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</c:forEach>
		</div>
    </jsp:body>
</t:simple>

<!-- Modal -->
<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="myModalLabel">Archivos</h3>
	</div>
	<div class="modal-body">
		<c:url var="actionUrlMatriz" value="/matriz/saveArchive" />
	
		<form id="frm_archive" style="padding-bottom: 40px" action="${actionUrlMatriz}" 
			enctype="multipart/form-data" method="POST"  class="form-inline">
		  	<input type="text" name="tipo" class="txt input-small" placeholder="Tipo">
		  	<input type="text" name="nombrearchivo" class="txt input-medium" placeholder="Nombre del Archivo">
		  	<input type="file" name="archivo" class="txt input-medium" placeholder="Archivo">
		  	<input type="hidden" name="idmatrizactividad" id="idmatrizactividad" value="" />
		  	<input type="hidden" name="idfuncion" id="idfuncion" value="" />
		  	<br />
		  	<button type="submit" id="" style="float:right" class="btn  btn-primary">Guardar</button>
		</form>
		
  		<table class="table uppertext">
  			<thead>
	  			<tr>
	  				<th>Tipo</th>
	  				<th>Nombre Archivo</th>
	  				<th>Archivo</th>
	  				<th></th>
	  			</tr>
  			</thead>
  			<tbody id="listArchivos">
  				<tr><td colspan="4"><div class="loader"></div></td></tr>
  			</tbody>
  		</table>
	</div>
	<div class="modal-footer">
  		<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
	</div>
</div>