// let callApi = (selectedValue) => {
//   let result = '';
//   fetch(`/api/currencies?currency=${selectedValue}`, {
//     method: 'GET',
//   }).then((res) => {
//     res.text().then(text => {
//       result = text;
//     })
//   });
//   return result;
// };

let select = document.querySelector('#recipient-country');
select.addEventListener('change', () => {
  let selectedValue = select.options[select.selectedIndex].value;

  fetch(`/api/currencies?currency=${selectedValue}`, {
    method: 'GET',
  }).then((res) => {
    res.text().then(text => {
      let currencyFromApi = text;
      let currency = document.querySelector('#currency');
      currency.querySelector('span').innerHTML = `${currencyFromApi} ${selectedValue}/USD`;
    })
  });
});

let submitBtn = document.querySelector('#submit-btn');
submitBtn.addEventListener('click', () => {
  let selectedValue = select.options[select.selectedIndex].value;
  let amounts = parseFloat(document.querySelector('#wiring-amounts').value);

  fetch(`/api/currencies/raw?currency=${selectedValue}`, {
    method: 'GET',
  }).then((res) => {
    res.text().then(text => {
      let currencyFromApi = text;
      let result = document.querySelector('#result');
      let reception = (currencyFromApi * amounts).toLocaleString(undefined, {maximumFractionDigits: 2});
      result.innerHTML = `수취금액은 ${reception} ${selectedValue} 입니다.`;
    })
  });
});