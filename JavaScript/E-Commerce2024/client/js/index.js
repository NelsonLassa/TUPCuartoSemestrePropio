const shopContent = document.getElementById("shopContent");

productos.forEach((prodcuts)=>{
    const content = document.createElement("div");
    content.innerHTML = `
    <img src="${prodcuts.img}">
    <h3>${prodcuts.productName}</h3>
    <p>${prodcuts.price}</p>
    `;
    shopContent.append(content);
});