// script.js

document.addEventListener('DOMContentLoaded', function() {
    var userIconButton = document.querySelector('.user-icon-button');

    // Retrieve the stored color from the cookie
    var storedColor = getCookie('userIconColor');

    // If no color is stored, generate a random color and store it in the cookie
    if (!storedColor) {
        storedColor = getRandomColor();
        setCookie('userIconColor', storedColor, 7); // Set the cookie path to '/'
    }

    userIconButton.style.backgroundColor = storedColor;
});

// Function to generate a random color
function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

// Function to set a cookie
function setCookie(name, value, days) {
    var expires = '';
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        expires = '; expires=' + date.toUTCString();
    }
    document.cookie = name + '=' + value + expires + '; path=/';
}

// Function to get a cookie value by name
function getCookie(name) {
    var nameEQ = name + '=';
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) === ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}