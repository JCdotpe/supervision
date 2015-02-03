<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="/actsupervision/" />

<form id="actsupervisionForm" method="post" accept-charset="UTF-8"
	action="${actionUrl }" class="form-horizontal upperx" >

	<fieldset>
	<!-- 	<legend></legend> -->

<p class="green info-form">Consulta de Actividades de Supervisión</p>


<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Fecha inicio Ejecución Supervisión</label>
        <div class="col-sm-3">
        	<input name = "fechaini" maxlength="10" class="form-control datepicker" value="${fechaini }" />
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType" class="col-sm-1 control-label">Fecha Fin Ejecución Supervisión</label>
        <div class="col-sm-3">
        	<input name = "fechafin" maxlength="10" class="form-control datepicker" value="${fechafin }"/>
        	<div class="help-block error"></div>
        </div>              
</div>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">EFA</label>
        <div class="col-sm-3">
        	<input name="nombrefa" maxlength="255" class="form-control" value="${nombrefa }"/>
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType"  class="col-sm-1 control-label">Supervisor Responsable</label>
        <div class="col-sm-3">
        	<input name="nombresup" maxlength="255" class="form-control" value="${nombresup }"/>
        	<div class="help-block error"></div>
        </div>              
</div>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Nivel de Gobierno</label>
        <div class="col-sm-3">
		<select name="nivel"  class="form-control cboActSuper">
		  <option value="0" >--- TODOS ---</option>
			<c:forEach var="nivel" items="${listNivel}" varStatus="i">
						<c:if test="${nivel.value == xnivel}">
					  		  <option selected value="${nivel.value}"/> ${nivel.label}</option>
					  	</c:if>
						<c:if test="${nivel.value != xnivel}">
					  		  <option value="${nivel.value}"/> ${nivel.label}</option>
					  	</c:if>					  	
			</c:forEach>		
         </select>  
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType"  class="col-sm-1 control-label">Informe</label>
        <div class="col-sm-3">
        	<input name="informe" maxlength="255" class="form-control" />
        	<div class="help-block error"></div>
        </div>              
</div>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Código Act. Programada</label>
        <div class="col-sm-3">
        	<input maxlength="60" name="codact" class="form-control" />
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType"  class="col-sm-1 control-label">Estado</label>
        <div class="col-sm-3">
		<select name="estado"  class="form-control cboActSuper">
			<c:forEach var="estado" items="${listEstadoAct}" varStatus="i">
						<c:if test="${estado.value == xestado}">
					  		  <option selected value="${estado.value}"/> ${estado.label}</option>
					  	</c:if>
						<c:if test="${estado.value != xestado}">
					  		  <option value="${estado.value}"/> ${estado.label}</option>
					  	</c:if>					  	
			</c:forEach>		
         </select>  
        	<div class="help-block error"></div>
        </div>              
</div>


<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Estado Matriz(Completo)</label>
        <div class="col-sm-3">
		<select name="estadomatriz"  class="form-control cboActSuper">
		  <option value="0" >--- TODOS ---</option>
			<c:forEach var="em" items="${listEstadoMatriz}" varStatus="i">
						<c:if test="${em.value == xestadomatriz}">
					  		  <option selected value="${em.value}"/> ${em.label}</option>
					  	</c:if>
						<c:if test="${em.value != xestadomatriz}">
					  		  <option value="${em.value}"/> ${em.label}</option>
					  	</c:if>					  	
			</c:forEach>		
         </select>  
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType"  class="col-sm-1 control-label">Estado del Informe</label>
        <div class="col-sm-3">
		<select name="estadoejec"  class="form-control cboActSuper">
		  <option value="0" >--- TODOS ---</option>
			<c:forEach var="ej" items="${listEstadoEjecucion}" varStatus="i">
						<c:if test="${ej.value == xestadoejec}">
					  		  <option selected value="${ej.value}"/> ${ej.label}</option>
					  	</c:if>
						<c:if test="${ej.value != xestadoejec}">
					  		  <option value="${ej.value}"/> ${ej.label}</option>
					  	</c:if>					  	
			</c:forEach>		
         </select>  
        	<div class="help-block error"></div>
        </div>              
</div>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Sector</label>
        <div class="col-sm-3">
        	<input maxlength="255" name="sector" class="form-control"/>
        	<div class="help-block error"></div>
        </div>               
</div>





	<button type="submit" class="btn btn-success">Consultar</button>

	</fieldset>
</form>