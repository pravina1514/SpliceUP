$(document).ready(function() {
	$('.dateFieldCpm').each(function() {
		var currentDate = $(this).html();
		if (currentDate.trim() != "") {
			var tempDate = currentDate.trim().split(" ")[0];
			var d = new Date(tempDate);
			var dd = d.getDate();
			var mm = d.getMonth() + 1;
			var yy = d.getFullYear();
			var newdate = dd + "/" + mm + "/" + yy;
			$(this).html(" " + newdate)
			$(this).removeClass("d-none");
		}
	});
});

function filterEvents() {
	window.location = "/event/services?cityName=" + $("#cityDropdown").val()
			+ "&location=" + $("#locationField").val();
}

function postComment() {

	$.ajax({
		type : 'POST',
		url : "/event/eventChat?eventId=" + $("#eventId").val() + "?message="
				+ $("#eventMessage").val(),
		success : function(resultData) {

		}
	});
}