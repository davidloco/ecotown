if (navigator.geolocation) {
	checkGeolocationByHTML5();
} else {
	checkGeolocationByLoaderAPI(); // HTML5 not supported! Fall back to Loader
	// API.
}

function checkGeolocationByHTML5() {
	navigator.geolocation.getCurrentPosition(function(position) {
		setMapCenter(position.coords.latitude, position.coords.longitude);
	}, function() {
		checkGeolocationByLoaderAPI(); // Error! Fall back to Loader API.
	});
}

function checkGeolocationByLoaderAPI() {
	if (google.loader.ClientLocation) {
		setMapCenter(google.loader.ClientLocation.latitude,
				google.loader.ClientLocation.longitude);
	} else {
		// Unsupported! Show error/warning?
	}
}

function setMapCenter(latitude, longitude) {
	w_gmap.getMap().setCenter(new google.maps.LatLng(latitude, longitude));
}

function updateMarkerAddress(str) {
	document.getElementById('direcci').value = str;
}

function updateMarkerPosition(latLng) {
	document.getElementById('lati').value = latLng.lat();
	document.getElementById('long').value = latLng.lng();
}

function updateMarkerStatus(str) {
	document.getElementById('markerStatus').innerHTML = str;
}

function geocodePosition(pos) {
	var geocoder = new google.maps.Geocoder();
	geocoder.geocode({
		latLng : pos
	}, function(responses) {
		if (responses.length > 0) {
			updateMarkerAddress(responses[0].formatted_address);
		} else {
			updateMarkerAddress('Cannot determine address at this location.');
		}
	});
}

function codeAddress() {
	var address = document.getElementById('address').value;
	var geocoder = new google.maps.Geocoder();
	var currentMarker = null;

	var image = '../resources/images/home.png';

	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == 'OK') {

			currentMarker = new google.maps.Marker({
				position : results[0].geometry.location,
				draggable : true,
				animation : google.maps.Animation.DROP,
				icon : image
			});

			updateMarkerPosition(results[0].geometry.location);
			geocodePosition(results[0].geometry.location);

			google.maps.event.addListener(currentMarker, 'dragstart',
					function() {
						updateMarkerAddress('Dragging...');
					});

			google.maps.event.addListener(currentMarker, 'drag', function() {
				updateMarkerStatus('Dragging...');
				updateMarkerPosition(currentMarker.getPosition());
			});

			google.maps.event.addListener(currentMarker, 'dragend', function() {
				updateMarkerStatus('Drag ended');
				geocodePosition(currentMarker.getPosition());
			});

			PF('w_gmap').addOverlay(currentMarker);

			setMapCenter(currentMarker.getPosition().lat(), currentMarker
					.getPosition().lng());
		} else {
			alert('Geocode was not successful for the following reason: '
					+ status);
		}
	});
}

PrimeFaces.locales['tr'] = {
	closeText : 'Cerrar',
	prevText : 'Anterior',
	nextText : 'Siguiente',
	currentText : 'Día Actual',
	monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
			'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre',
			'Diciembre' ],
	monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago',
			'Sep', 'Oct', 'Nov', 'Dic' ],
	dayNames : [ 'Domingo', 'Lunes', 'Mates', 'Miercoles', 'Jueves', 'Viernes',
			'Sabado' ],
	dayNamesShort : [ 'Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa' ],
	dayNamesMin : [ 'Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa' ],
	weekHeader : 'Se',
	firstDay : 1,
	isRTL : false,
	showMonthAfterYear : false,
	yearSuffix : '',
	month : 'Mes',
	week : 'Semana',
	day : 'Día',
	allDayText : 'Todo el Dia'
};