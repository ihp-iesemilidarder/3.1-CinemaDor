<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="error/error-page.jsp"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.cinema.service.FilmService" %>
<%@ page import="com.cinema.dto.Film"%>

<%
    // Lectura de paràmetres: codi de la pel·lícula
    Integer codiFilm = Integer.parseInt(request.getParameter("codi"));
    System.out.println("Codi film:"+codiFilm);

 	// Recuperam l'objecte pel·lícula
	FilmService serveiFilm = new FilmService();
	Film film = serveiFilm.getFilm(codiFilm);	
	
	// Necessari per ser processat per JSLT
    request.setAttribute("pelicula", film);
	
	// Variable per determinar si mostra la fitxa html de la pel·lícula o no
	boolean trobada = (film!=null);
    request.setAttribute("exist", trobada);
 %>
 
<%-- capçalera --%>
<jsp:include page="./common/header.jsp" />

<c:if test = "${exist}">

		<div class="container my-4">
			<div class="card mb-3">
				<div class="row no-gutters">
					<div class="col-md-4">
						<img src="img/${pelicula.caratula}" class="card-img" alt="..." style="height:450px">
					</div>
					<div class="col-md-8">
					
						<%-- Presentació de les dades de la pel·lícula --%>
						<div class="card-body">
							<h5 class="card-title"><c:out value="${pelicula.nom}"/></h5>
							<div class="card-text">

								<dl class="row">
									<dt class="col-sm-3">Sinopsi</dt>
									<dd class="col-sm-9"><c:out value="${pelicula.sinopsi}"/></dd>

									<dt class="col-sm-3">Gènere</dt>
									<dd class="col-sm-9">
										<c:out value="${pelicula.genere}"/>
									</dd>

									<dt class="col-sm-3">Estrena</dt>
									<dd class="col-sm-9"><c:out value="${pelicula.estreno?'Sí':'No'}"/></dd>
									
									 <%-- Transformació de LocaleData a Date i després al format català --%>
									<fmt:parseDate value="${pelicula.dataEstreno}" pattern="yyyy-MM-dd" var="dataEstrenoParse" type="date" />
									<fmt:formatDate value="${dataEstrenoParse}" var="data_estreno" pattern="dd-MM-yyyy"/>
									<dt class="col-sm-3">Release</dt>
									<dd class="col-sm-9"><c:out value="${data_estreno}"/></dd>

									<dt class="col-sm-3 text-truncate">Edat recomanada:</dt>
									<dd class="col-sm-9"><img src="img/age-tp.png" style="width:20px"/>
								        
								        <%-- Missatge segons l'edat recomanada --%>
								        <c:choose>
								            <c:when test="${pelicula.edatRec eq 18}">
								                <c:out value="${'Edat recomanora a partir de 18'}" escapeXml="false" />
								                <c:out value="${'<p>Conté contigut que pot ser especialment sensible<p>'}" escapeXml="false"/>
								            </c:when>
								            <c:when test="${pelicula.edatRec eq 16}">
								                <c:out value="${'Edat recomanora a partir de 16. Pot contenir escenes i vocabulari violent'}" escapeXml="false"/>
								            </c:when>
								            <c:otherwise>
								                <c:out value="${'Tots els públics. Divertida per tota la familia'}" escapeXml="false"/>
								            </c:otherwise>
								        </c:choose>
															
									</dd>

									<dt class="col-sm-3 text-truncate">Horari</dt>
									<dd class="col-sm-9">
									
								       <%-- Es mostra horari del cinema --%> 
							           <c:forEach var="session" varStatus="loop" items="${pelicula.horari}">
							              <c:choose>
							              	<c:when test = "${session.club==1 }">
							              		<span class="badge badge-warning"> <c:out value="${session.hourIni}"/> </span>
							              	</c:when>
							              	<c:otherwise>
							              		<span class="badge badge-info"> <c:out value="${session.hourIni}"/> </span>
							              	</c:otherwise>
							              </c:choose>  
							           </c:forEach>
							           
									</dd>
									<dt class="col-sm-3 text-truncate">Duration</dt>
									<dd class="col-sm-9"><c:out value="${pelicula.duration }"></c:out>h</dd>
								</dl>
								<div class="container text-center">
									<button type="button" class="btn btn-warning" name="button" onclick="location='list-films.jsp'">Torna</button>
								</div>
							</div>
							<p class="card-text"><small class="text-muted">Descompte del 10% per menors de 8 anys</small></p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
</c:if>

<%-- Missatge d'avís controlat si no s'ha trobat cap pel·lícula amb el codi especificat --%>
<c:if test = "${!exist}">
    <jsp:forward page = "codi_incorrecte.jsp" />     
</c:if>

<%-- Foote: inclou el resultat de la URL --%>
<jsp:include page="./common/footer.jsp" />
                   

