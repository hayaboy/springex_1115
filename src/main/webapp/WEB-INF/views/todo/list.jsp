<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Hello, world!</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
<!--<h1>Hello, world!</h1>-->
<div>

    <div class="row">
        <!--<h1>Header</h1>-->
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Link</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    Dropdown
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled">Disabled</a>
                            </li>
                        </ul>
                        <form class="d-flex">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <div class="row content">
        <!--        <h1>Content</h1>-->
        <div class="col">
            <div class="card">
                <div class="card-header">
                    글 목록
                </div>
                <div class="card-body">

                    <h5 class="card-title"> 해야할 일 목록 </h5>

                    <table class="table">

                        <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">제목</th>
                            <th scope="col">누가</th>
                            <th scope="col">언제까지</th>
                            <th scope="col">완료여부</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%-- 페이징 전 화면 --%>
<%--                        <c:forEach var="dto" items="${dtoList}">--%>
<%--                            <tr>--%>
<%--                                <th scope="row"><c:out value="${dto.tno}"/></th>--%>
<%--                                <td><a href="/todo/read?tno=${dto.tno}" class="text-decoration-none"> <c:out value="${dto.title}"/> </a>   </td>--%>
<%--                                <td><c:out value="${dto.writer}"/></td>--%>
<%--                                <td><c:out value="${dto.dueDate}"/></td>--%>
<%--                                <td><c:out value="${dto.finished}"/></td>--%>

<%--                            </tr>--%>
<%--                        </c:forEach>--%>

                        <%-- 페이징 후 화면 --%>
                        <c:forEach var="dto" items="${responseDTO.dtoList}">
                            <tr>
                                <th scope="row"><c:out value="${dto.tno}"/></th>
                                <td><a href="/todo/read?tno=${dto.tno}" class="text-decoration-none"> <c:out value="${dto.title}"/> </a>   </td>
                                <td><c:out value="${dto.writer}"/></td>
                                <td><c:out value="${dto.dueDate}"/></td>
                                <td><c:out value="${dto.finished}"/></td>

                            </tr>
                        </c:forEach>

                        </tbody>


                    </table>

                    <%--페이징 화면 --%>

                    <div class="float-end">
                        <ul class="pagination flex-wrap">
                            <c:if test="${responseDTO.prev}">
                                <li class="page-item">
                                    <a class="page-link" data-num="${responseDTO.start -1}">Previous</a>
                                </li>
                            </c:if>

                            <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                                <li class="page-item ${responseDTO.page == num? "active":""} ">
                                    <a class="page-link"  data-num="${num}">${num}</a></li>
                            </c:forEach>

                            <c:if test="${responseDTO.next}">
                                <li class="page-item">
                                    <a class="page-link"  data-num="${responseDTO.end + 1}">Next</a>
                                </li>
                            </c:if>
                        </ul>

                    </div>

                    <script>

                        document.querySelector(".pagination").addEventListener("click", function (e) {
                             e.preventDefault()
                             e.stopPropagation()
                            const target = e.target
                            console.log("이벤트 대상", target);
                            console.log("target.tagName : ", target.tagName);
                            // 대문자 A : anchor
                            if(target.tagName !== 'A') {
                                return
                            }

                            const num = target.getAttribute("data-num")

                            self.location = `/todo/list?page=\${num}` //백틱(` `)을 이용해서 템플릿 처리

                        }, false);



                    </script>

                </div>
            </div>
        </div>
    </div>


    <div class="row footer">
        <!--        <h1>Footer</h1>-->
        <div class="row   fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1 ">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>
    </div>


</div>


<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>


</body>
</html>