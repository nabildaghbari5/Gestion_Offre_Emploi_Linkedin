// JavaScript pour la fonctionnalité de notation
const ratingStars = document.querySelectorAll('.rating i');
ratingStars.forEach((star, index) => {
  star.addEventListener('click', () => {
    // Ajouter la classe active à l'étoile cliquée et à toutes les étoiles avant elle
    for (let i = 0; i <= index; i++) {
      ratingStars[i].classList.add('active');
    }
    // Supprimer la classe active de toutes les étoiles après l'étoile cliquée
    for (let i = index + 1; i < ratingStars.length; i++) {
      ratingStars[i].classList.remove('active');
    }
  });
});
