const modalOverlay = document.getElementById("modal-overlay");
const modalContainer = document.getElementById("modal-container");

const cartBtn = document.getElementById("cart-btn");

const displayCart = () => {
  modalContainer.innerHTML = "";
  modalContainer.style.display = "block";
  modalOverlay.style.display = "block";
  // Modal Header
  const modalHeder = document.createElement("div");

  const modalClose = document.createElement("div");
  modalClose.innerText = "❌";
  modalClose.className = "modal-close";
  modalHeder.append(modalClose);

  modalClose.addEventListener("click", () => {
    modalContainer.style.display = "none";
    modalOverlay.style.display = "none";
  });

  const modalTitlte = document.createElement("div");
  modalTitlte.innerText = "Carrito";
  modalTitlte.className = "modal-title";
  modalHeder.append(modalTitlte);

  modalContainer.append(modalHeder);

  // Modal Body
  cart.forEach((productos) => {
    const modalBody = document.createElement("div");
    modalBody.className = "modal-body";
    modalBody.innerHTML = `
        <div class="product">
                <img class="product-img" src="${productos.img}"/>
                <div class="product-info">
                    <h4>${productos.productName}
                </div>
            <div class="quantity">
                <span class="quantity-btn-decrese">-</span>
                <span class="quantity-input">${productos.quanty}</sapn>
                <span class="quantity-btn-increse">+</span>
            </div>
                <div class="price">${productos.price * productos.quanty} $</div>
                <div class="delete-product">❌</div>
        </div>
        `;
    modalContainer.append(modalBody);
  });

  // modal footer

  const modalFooter = document.createElement("div");
  modalFooter.className = "modal-footer";
  modalFooter.innerHTML = `
    <div class="total-price"> Totla :)</div>
    `;

  modalContainer.append(modalFooter);
};
cartBtn.addEventListener("click", displayCart);
