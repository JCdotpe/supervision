<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="actionUrl" value="/suparchivo/savefile?id=${supe.id}" />
	<form:form method="post" action="${actionUrl}" id="formFilesup"
	        modelAttribute="command" enctype="multipart/form-data">
	<p class="green info-form">Datos del Archivo</p>
	
	<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Tipo</label>
        <div class="col-sm-3">
			<select id="tipo" name="tipo" class="form-control">
				<c:forEach items="${listSupfiles}" var="sp">
				        <option value="${sp.value}">${sp.label}</option>
				    </c:forEach>					          
	         </select>		
	         <div class="help-block error"></div>
        </div>      
         
	</div>
	    <table id="fileTable">    
	        <tr>
	            <td><input name="file" type="file" class="archivos"/></td>
	             
	        </tr>
	           <tr>
	        <td><b>Extensiones permitidas:</b> JPG | PNG | GIF | PDF | DOC | DOCX</td>
	         </tr>
	    </table>
	    <br/>	<button type="submit" class="btn btn-success">Subir Archivo</button>
	</form:form>
		
  