document.addEventListener('DOMContentLoaded', function() {
	const userIconButton = document.querySelector('.user-icon-button');

	let storedColor = getCookie('userIconColor');

	if (!storedColor) {
		storedColor = getRandomColor();
		setCookie('userIconColor', storedColor, 7);
	}

	userIconButton.style.backgroundColor = storedColor;
});

function getRandomColor() {
	const letters = '0123456789ABCDEF';
	let color = '#';
	for (let i = 0; i < 6; i++) {
		color += letters[Math.floor(Math.random() * 16)];
	}
	return color;
}

function setCookie(name, value, days) {
	let expires = '';
	if (days) {
		const date = new Date();
		date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
		expires = '; expires=' + date.toUTCString();
	}
	document.cookie = name + '=' + value + expires + '; path=/';
}

function getCookie(name) {
	const nameEQ = name + '=';
	const ca = document.cookie.split(';');

	for (const cookie of ca) {
		let c = cookie.trim();
		if (c.startsWith(nameEQ)) {
			return c.substring(nameEQ.length);
		}
	}

	return null;
}

function confirmLogout() {
	const confirmLogout = confirm("Are you sure you want to logout?");
	if (confirmLogout) {
		window.location.href = "@{/logout}";
	} else {
		event.preventDefault();
	}
}

document.addEventListener('DOMContentLoaded', function() {
	var popup = document.getElementById('popup');

	if (popup.innerText.trim() !== '') {
		popup.style.display = 'block';

		setTimeout(function() {
			popup.style.display = 'none';
		}, 5000); // Adjust the time duration as needed
	}
});