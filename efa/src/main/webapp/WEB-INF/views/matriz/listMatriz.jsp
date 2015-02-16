<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:simple>
    <jsp:attribute name="header">
    
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">OEFA</p>    
    
    <script type="text/javascript" src='<c:url value="/web-resources/js/lib/jquery.form.js"/>'></script>   
 	<script type="text/javascript" src='<c:url value="/web-resources/js/lib/additional-methods.min.js"/>'></script>
 	<script type="text/javascript" src='<c:url value="/web-resources/js/js-for-listMatriz.js?1"/>'></script>   
 	
 
    </jsp:attribute>
    
    <jsp:body>
		<span>Actividad</span>
		<h2>Matriz</h2>
		<h5 class="head_matriz"><span>Código de Actividad:</span> ${actividad.codactividad}</h5>
		<h5 class="head_matriz"><span>Ubigeo de Actividad:</span> ${actividad.departamentodes} - ${actividad.provinciades} - ${actividad.distritodes} </h5>
		<h5 class="head_matriz"><span>Nombre Efa:</span> ${nombreefa}</h5>
		<h5 class="head_matriz"><span>Fecha de Inicio de Actividad:</span> ${actividad.fechaini}</h5>
		<br />
		<br />
		<a href="/efa/actsupervision/" class="btn" style="float:right; background:#5faf2f; color:#ffffff; font-size:15px">Regresar a la consulta</a>
		<br />
		<br />
		<ul class="nav nav-tabs" style="clear:both" id="tabMatriz">
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
						  				<div class="col_td col_verificable">Completado</div>
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
											<div style="text-align: center;" class="col_td col_verificable">
											
											<c:if test="${componente.completado != null}">
												${componente.completado}
											</c:if>
											<c:if test="${componente.completado == null}">
												NO
											</c:if>
											
											</div>
							  			</div>
						  			
					  					<div class="block_td block_td_bot">
					  						<table class="table uppertext table_funciones">
			  									<thead>
				  									<tr>
				  										<th width="20%">Funciones</th>
				  										<th width="18%">Indicadores</th>
				  										<th width="2%"></th>
				  										<th width="15%">Observacion</th>
				  										<th width="15%">Base legal</th>
				  										<th width="10%">Verificable</th>
				  										<th width="10%">Completo</th>
				  										<th width="10%"></th>
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
													  										<td width="20%">${funciones.descripcionfuncion}</td>
													  										<td width="20%" colspan="2">
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
																  														<td valign="top"><input ${checked} type="checkbox" class="chk_indicador" value="${indicadores.idindicador}" name="chk_indicador" /></td>
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
													  										<td width="15%">
													  											<textarea class="txtaObservacion" name="txtaObservacion">${actividadfuncion.observaciones}</textarea>
													  										</td>
													  										<td width="15%">${funciones.baselegal}</td>
													  										<td width="10%">${funciones.verificable}</td>
													  										<td width="10%">
													  											<c:if test="${actividadfuncion.estadomatrizactividadfunciones == '0'}"> 
													  												No
												  												</c:if>
												  												<c:if test="${actividadfuncion.estadomatrizactividadfunciones != '0'}"> 
												  													Si
														  										</c:if>
													  										</td>
													  										<td width="10%">
												  											<c:if test="${componente.completado == null}">  											
														  											<input type="hidden" name="idmatrizactividad" value="${matrizactividad.idmatrizactividad}">
														  											<input type="hidden" name="idfuncion" value="${funciones.idfuncion}">
														  											<input type="hidden" name="idcomponente" value="${componente.idcomponente}">
														  											
														  											<a href="#myModal" data-disabled="false" role="button" data-toggle="modal" data-titulo="${funciones.descripcionfuncion}"
														  												data-matrizactividad="${matrizactividad.idmatrizactividad}" 
														  												data-funcion="${funciones.idfuncion}" class="btn btnArchive">Archivos</a>
														  											<br /><br />
														  											<a href="#" class="btn btn_save_funcion " 
														  												data-pos="${loopCounter3.count}"
														  												data-matrizactividad="${matrizactividad.idmatrizactividad}" 
														  												data-funcion="${funciones.idfuncion}">Guardar</a>
												  											</c:if>
												  												<c:if test="${componente.completado != null}"> 
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
		<h4 id="myModalLabel">Archivos</h4>
	</div>
	<div class="modal-body">
		<c:url var="actionUrlMatriz" value="/matriz/saveArchive" />
	
		<form id="frm_archive" style="padding-bottom: 40px" action="${actionUrlMatriz}" 
			enctype="multipart/form-data" method="POST"  class="form-inline">

			<div>
				<label style="margin: 12px 35px 0px 0px; float: left;">Tipo de Archivo</label>
				<div style="display: inline-block;">
					<select style="width: 390px;" name="tipo" class="txt input-small required">
				  		<option value="">Seleccionar Tipo</option>
				  		<option value="Memo">Memo</option>
				  		<option value="Informe">Informe</option>
				  		<option value="Oficio">Oficio</option>
				  		<option value="Otro">Otro</option>
				  	</select>
				</div>
			</div>
			<div>
				<label style="float: left; margin-top: 12px; margin-right: 10px;">Nombre del Archivo:</label>
				<div>
					<input style="width: 390px;" type="text" name="nombrearchivo" class="txt input-medium required" placeholder="Nombre del Archivo">
				</div>
			</div>
			<div>
		  		<label style="float: left; margin: 12px 10px 10px 0px;">Seleccionar Archivo:</label>
		  		<div>
		  			<input accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document" style="width: 390px;" type="file" name="archivo" id="archivo" class="txt input-medium required" placeholder="Archivo">
		  			<span>(Formato PDF y WORD, Peso max de 5Mb)</span>
		  		</div>
		  		
		  	</div>
		  	
		  	
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