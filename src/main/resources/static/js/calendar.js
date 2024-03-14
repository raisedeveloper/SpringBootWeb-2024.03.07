<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
	<header th:replace="~{fragments/base :: head}"></header>
	<style>
		th { text-align: center; width: 14.28%; }
	</style>
	<script src="/abbs/js/calendar.js"></script>
</head>
<body>
	<div th:insert="~{fragments/base :: top}"></div>

	<div class="container" style="margin-top:80px">
		<div class="row">
			<div class="col-3">
				<aside th:replace="~{fragments/base :: aside}"></aside>
			</div>

			<div class="col-9">
				<main id="main">
					<h3><strong>일정표</strong></h3>
					<hr>
					<div class="d-flex justify-content-between">
						<div th:text="${today}">2024-01-12(금)</div>
						<div>
							<a href="/abbs/schedule/calendar/left2"><i class="fa-solid fa-angles-left"></i></a>
							<a href="/abbs/schedule/calendar/left"><i class="fa-solid fa-angle-left ms-2"></i></a>
							<span class="badge bg-primary mx-2" th:text="|${year}.${month}|">2024.01</span>
							<a href="/abbs/schedule/calendar/right"><i class="fa-solid fa-angle-right me-2"></i></a>
							<a href="/abbs/schedule/calendar/right2"><i class="fa-solid fa-angles-right"></i></a>
						</div>
						<div>
							<a href="#" onclick="addAnniversary()"><i class="fa-solid fa-pen me-2"></i> 기념일 추가</a>
						</div>
					</div>
					<table class="table table-bordered mt-2">
						<tr>
							<th class="text-danger">일</th>
							<th>월</th><th>화</th><th>수</th><th>목</th><th>금</th>
							<th class="text-primary">토</th>
						</tr>
						<tr th:each="week: ${calendar}">
							<div th:each="day: ${week}">
								<td th:style="|height: ${height}px; ${todaySdate == day.sdate ? background-color :  #efffff;' : ''}|">
                  // '오늘'의 색을 다르게 함 (day.sdate ? background-color)
									[[${day.day}]]<br>
									[[${day.sdate}]]
								</td>
							</div>
						</tr>
					</table>


				</main>
			</div>
		</div>
	</div>

	<footer th:replace="~{fragments/base :: bottom}"></footer>
</body>
</html>