const modalOverlay = document.getElementById("modal-overlay");
const modalContainer = document.getElementById("modal-container");

const cartBtn = document.getElementById("cart-btn");

const displayCart = () => {
    modalContainer.innerHTML = "";
    modalContainer.style.display = "block";
    modalOverlay.style.display = "block"
    // Modal Header
    const modalHeder = document.createElement("div");

    const modalClose = document.createElement("div");
    modalClose.innerText = "❌";
    modalClose.className = "modal-close";
    modalHeder.append(modalClose);

    modalClose.addEventListener("click", () => {
        modalContainer.style.display = "none";
        modalOverlay.style.display = "none";
    })

    const modalTitlte = document.createElement("div");
    modalTitlte.innerText = "Carrito";
    modalTitlte.className = "modal-title";
    modalHeder.append(modalTitlte);

    modalContainer.append(modalHeder);
}

cartBtn.addEventListener("click", displayCart);