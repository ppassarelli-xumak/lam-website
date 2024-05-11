// TODO adding components/events, create class export

const element = document.querySelector('.globalheader');

const menu = element.querySelector('.globalheader__menu-button');

const search = element.querySelector('.globalheader__search-button');
const searchSection = element.querySelector('.globalheader__search-section');

const accountCta = element.querySelector('.account-cta');
const accountContent = element.querySelector('.account-ctas-content');

const content = element.querySelector('.globalheader__content');

const options = element.querySelectorAll('.globalheader__option');

/*const levelZero = element.querySelector('.level-0');
const linksLevels = levelZero.querySelectorAll('.globalheader__nav__link');
const sections = Array.from(element.querySelectorAll('.globalheader__nav'));
sections.shift();
console.log('Secciones', sections);*/

options.forEach((option) => {
    option.addEventListener('click', () => {
        const icon = option.querySelector('span')

        if (icon.classList.contains('icon-chevron-left') || icon.classList.contains('icon-chevron-right')) {
          icon.classList.toggle('icon-chevron-left');
          icon.classList.toggle('icon-chevron-right');
        } else {
          icon.classList.toggle('icon-chevron-down');
          icon.classList.toggle('icon-chevron-up');
        }

        //content.classList.toggle('hidden-desktop');
        content.classList.toggle('animation');
        element.classList.toggle('active');
    })
})

menu.addEventListener('click', () => {
  console.log('menu clicked');
  content.classList.toggle('animation');
  menu.classList.toggle('icon-menu');
  menu.classList.toggle('icon-close');
});

search.addEventListener('click', () => {
  console.log('search clicked');
  searchSection.classList.toggle('hidden');
})


/*linksLevels.forEach((button, index) => {
  button.addEventListener('click', () => {
    return null
  })
})*/


accountCta.addEventListener('click', () => {
  console.log('account clicked')
  const icon = accountCta.querySelector('span');
  icon.classList.toggle('icon-chevron-down');
  icon.classList.toggle('icon-chevron-up');

  accountContent.classList.toggle('animation');
})


// Add function hover change image