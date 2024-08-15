describe('Signup Automation', () => { 
  it('Should sign up a new user successfully', () => { 
    cy.visit('https://alphapay.netlify.app/'); // Load the signup page
    cy.get('.info > .btn').click(); // Click on the get started button

    // Fill out the signup form
    cy.get('.react-reveal > :nth-child(1) > div > input').type('Irene Ezea').wait(500);
    cy.get(':nth-child(2) > input').type('qa-irene').wait(500); 
    cy.get(':nth-child(3) > input').type('08069948086').wait(500); 
    cy.get(':nth-child(4) > input').type('emeshiliirene@gmail.com').wait(500); 
    cy.get(':nth-child(5) > input').type('Qwerty1234?!').wait(500); 
    cy.get(':nth-child(6) > input').type('Qwerty1234?!').wait(500); 

    cy.get('.button').click().wait(2000); // Submit the form
    cy.contains('Signup Successful').should('be.visible'); // Verify successful signup
  });
});

describe('Sign In Automation', () => {
  it('Should change password successfully', () => {
    cy.visit('https://alphapay.netlify.app/auth/login');// Load the login page

       // Enter login credentials
    cy.get(':nth-child(1) > input').type('emeshiliirene@gmail.com');
    cy.get('.password').type('Qwerty1234?!');

    cy.get('.button').click().wait(2000); // Submit the login form
    cy.contains('Successful').should('be.visible').wait(2000); // Verify successful login
  });
});

describe('Password Change Automation', () => {
  it('Should change password successfully', () => {
    cy.visit('https://alphapay.netlify.app/auth/login');// Load the login page

    // Log in with current password
    cy.get(':nth-child(1) > input').type('emeshiliirene@gmail.com');
    cy.get('.password').type('Qwerty1234?!');
    cy.get('.button').click().wait(2000);
    cy.contains('Successful').should('be.visible').wait(2000);

     // Navigate to the security settings page
    cy.get('.dashboard_nav_profile > a > img').click();
    cy.get('[href="/dashboard/settings/security"]').click();
    
     // Change the password
    cy.get('.old_password_form > input').type('Qwerty1234?!').wait(2000);
    cy.get('.new_password_form > input').type('Asdfghj1234567?!').wait(2000);
    cy.get('.password_security_change > form > .btn_cont > .button').click().wait(2000);
  });
});

describe('User Details Update Automation', () => {
  it('Should update the full name and username successfully', () => {

    cy.visit('https://alphapay.netlify.app/auth/login');// Load the login page
      
    // Log in with updated password
    cy.get(':nth-child(1) > input').type('emeshiliirene@gmail.com');
    cy.get('.password').type('Asdfghj1234567?!');
    cy.get('.button').click().wait(2000);
    cy.contains('Successful').should('be.visible').wait(2000);

    // Navigate to the profile settings
    cy.get('.dashboard_nav_profile > a > img').click();
    cy.get('.settings_tab > .active').click();
      
    // Update full name and username
    cy.get('form > :nth-child(1) > input').clear().type('Irene Emeshili').wait(1000);
    cy.get('form > :nth-child(2) > input').clear().type('Ms Irene').wait(1000);
    cy.get('form > .button').wait(2000);
  })
});

describe('Logout Automation', () => {
  it('Should Logout', () => {

    // Log in with updated password
    cy.visit('https://alphapay.netlify.app/auth/login');
    cy.get(':nth-child(1) > input').type('emeshiliirene@gmail.com');
    cy.get('.password').type('Asdfghj1234567?!');
    cy.get('.button').click().wait(2000);
    cy.contains('Successful').should('be.visible').wait(2000);

     // Perform logout
    cy.get('.dashboard_nav_profile > a > img').click().wait(2000);
    cy.get('[href="/coming-soon"]').click().wait(2000);
  })
});
