let parrafos = document.getElementsByTagName("p");

for (const element of parrafos) {
  element.innerHTML = element.innerText
    .split(" ")
    .map((palabra) => //Lambda o flecha
      palabra.length > 8 ? `<span class = "yb">${palabra}</span>` : palabra
    )
    .join(" ");
}

var css = document.createElement("style");
css.innerHTML = ".yb {background-color: yellow;}";
document.getElementsByTagName("head")[0].appendChild(css);

/*document.getElementsByTagName("p")[1].innerHTML = document.getElementsByTagName("p")[1]
  .innerText.split(" ")
  .map((palabra) =>
    palabra.length > 8 ? `<span class = "yb">${palabra}</span>` : palabra
  )
  .join(" ");
var css = document.createElement("style");
css.innerHTML = ".yb {background-color: yellow;}";
document.getElementsByTagName("head")[0].appendChild(css);*/ //llamado del css desde el head
