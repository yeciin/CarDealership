<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Car Dealership</title>
        </head>

        <body>
            <header>
                <nav>
                    <h1>Car Dealership</h1>
                </nav>
            </header>
            <br>

            <div>
                <div>
                    <h3>List of Cars</h3>
                    <hr>
                    <div><a href="<%=request.getContextPath()%>/new">Add New Car</a></div>
                    <br>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Make</th>
                                <th>Model</th>
                                <th>Year</th>
                                <th>Mileage</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${listCar}">
                                <tr>
                                    <td>
                                        <c:out value="${car.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${car.make}" />
                                    </td>
                                    <td>
                                        <c:out value="${car.model}" />
                                    </td>
                                    <td>
                                        <c:out value="${car.year}" />
                                    </td>
                                    <td>
                                        <c:out value="${car.mileage}" />
                                    </td>
                                    <td>
                                        <c:out value="${car.price}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${car.id}' />">Edit </a><a
                                            href="delete?id=<c:out value='${car.id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <img src="https://preview.redd.it/9my9pzmf2s771.png?auto=webp&s=5ff7c47100f9ac3edb284f9612ec3fe934bf311a" />
            </div>
        </body>

        </html>