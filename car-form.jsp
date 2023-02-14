<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Car dealership</title>
        </head>

        <body>
            <header>
                <nav>
                    <div>Car Dealership</div>
                    <div>
                        <ul>
                            <li><a href="<%=request.getContextPath()%>/list">Cars</a></li>
                        </ul>
                    </div>
                </nav>
            </header>
            <br>

            <div>
                <div >
                    <div >
                        <c:if test="${car != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${car == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${car != null}">
                                    Edit Car
                                </c:if>
                                <c:if test="${car == null}">
                                    Add New Car
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${car != null}">
                            <input type="hidden" name="id" value="<c:out value='${car.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Car Make</label> <input type="text" value="<c:out value='${car.make}' />"
                                class="form-control" name="make" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Car Model</label> <input type="text" value="<c:out value='${car.model}' />"
                                class="form-control" name="model" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Car Year</label> <input type="text" value="<c:out value='${car.year}' />"
                                class="form-control" name="year" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Car Mileage</label> <input type="text" value="<c:out value='${car.mileage}' />"
                                class="form-control" name="mileage">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Car Price</label> <input type="text" value="<c:out value='${car.price}' />"
                                class="form-control" name="price" required="required">
                        </fieldset>


                        <button type="submit">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>