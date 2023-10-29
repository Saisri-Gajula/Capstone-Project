'use strict';

customElements.define('compodoc-menu', class extends HTMLElement {
    constructor() {
        super();
        this.isNormalMode = this.getAttribute('mode') === 'normal';
    }

    connectedCallback() {
        this.render(this.isNormalMode);
    }

    render(isNormalMode) {
        let tp = lithtml.html(`
        <nav>
            <ul class="list">
                <li class="title">
                    <a href="index.html" data-type="index-link">capstone-frontend documentation</a>
                </li>

                <li class="divider"></li>
                ${ isNormalMode ? `<div id="book-search-input" role="search"><input type="text" placeholder="Type to search"></div>` : '' }
                <li class="chapter">
                    <a data-type="chapter-link" href="index.html"><span class="icon ion-ios-home"></span>Getting started</a>
                    <ul class="links">
                        <li class="link">
                            <a href="overview.html" data-type="chapter-link">
                                <span class="icon ion-ios-keypad"></span>Overview
                            </a>
                        </li>
                        <li class="link">
                            <a href="index.html" data-type="chapter-link">
                                <span class="icon ion-ios-paper"></span>README
                            </a>
                        </li>
                                <li class="link">
                                    <a href="dependencies.html" data-type="chapter-link">
                                        <span class="icon ion-ios-list"></span>Dependencies
                                    </a>
                                </li>
                                <li class="link">
                                    <a href="properties.html" data-type="chapter-link">
                                        <span class="icon ion-ios-apps"></span>Properties
                                    </a>
                                </li>
                    </ul>
                </li>
                    <li class="chapter modules">
                        <a data-type="chapter-link" href="modules.html">
                            <div class="menu-toggler linked" data-bs-toggle="collapse" ${ isNormalMode ?
                                'data-bs-target="#modules-links"' : 'data-bs-target="#xs-modules-links"' }>
                                <span class="icon ion-ios-archive"></span>
                                <span class="link-name">Modules</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                        </a>
                        <ul class="links collapse " ${ isNormalMode ? 'id="modules-links"' : 'id="xs-modules-links"' }>
                            <li class="link">
                                <a href="modules/AppModule.html" data-type="entity-link" >AppModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-bs-toggle="collapse" ${ isNormalMode ?
                                            'data-bs-target="#components-links-module-AppModule-9496080e10cd5a846e8708edd3f53648b27cb953ccafb4e3ae4624c8a788d298b2266a869ed51d49faf8e0e5f92bc7ff26640714b77d228894e5bbcb81cfb10a"' : 'data-bs-target="#xs-components-links-module-AppModule-9496080e10cd5a846e8708edd3f53648b27cb953ccafb4e3ae4624c8a788d298b2266a869ed51d49faf8e0e5f92bc7ff26640714b77d228894e5bbcb81cfb10a"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-AppModule-9496080e10cd5a846e8708edd3f53648b27cb953ccafb4e3ae4624c8a788d298b2266a869ed51d49faf8e0e5f92bc7ff26640714b77d228894e5bbcb81cfb10a"' :
                                            'id="xs-components-links-module-AppModule-9496080e10cd5a846e8708edd3f53648b27cb953ccafb4e3ae4624c8a788d298b2266a869ed51d49faf8e0e5f92bc7ff26640714b77d228894e5bbcb81cfb10a"' }>
                                            <li class="link">
                                                <a href="components/AppComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >AppComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/CompletedpaymentsComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >CompletedpaymentsComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/CuringComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >CuringComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/CustomerComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >CustomerComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/DuePaymentsComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >DuePaymentsComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/FirstremindersComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >FirstremindersComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/LoginComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >LoginComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/NavbarComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >NavbarComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PaymentactionsComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >PaymentactionsComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/SecondremindersComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >SecondremindersComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/TerminationremindersComponent.html" data-type="entity-link" data-context="sub-entity" data-context-id="modules" >TerminationremindersComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/AppRoutingModule.html" data-type="entity-link" >AppRoutingModule</a>
                            </li>
                </ul>
                </li>
                        <li class="chapter">
                            <div class="simple menu-toggler" data-bs-toggle="collapse" ${ isNormalMode ? 'data-bs-target="#injectables-links"' :
                                'data-bs-target="#xs-injectables-links"' }>
                                <span class="icon ion-md-arrow-round-down"></span>
                                <span>Injectables</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                            <ul class="links collapse " ${ isNormalMode ? 'id="injectables-links"' : 'id="xs-injectables-links"' }>
                                <li class="link">
                                    <a href="injectables/DunningProcessService.html" data-type="entity-link" >DunningProcessService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/SnackbarService.html" data-type="entity-link" >SnackbarService</a>
                                </li>
                            </ul>
                        </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-bs-toggle="collapse" ${ isNormalMode ? 'data-bs-target="#interfaces-links"' :
                            'data-bs-target="#xs-interfaces-links"' }>
                            <span class="icon ion-md-information-circle-outline"></span>
                            <span>Interfaces</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? ' id="interfaces-links"' : 'id="xs-interfaces-links"' }>
                            <li class="link">
                                <a href="interfaces/CompletedPayments.html" data-type="entity-link" >CompletedPayments</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Customer.html" data-type="entity-link" >Customer</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/DuePayments.html" data-type="entity-link" >DuePayments</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Paymentplan.html" data-type="entity-link" >Paymentplan</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Reminders.html" data-type="entity-link" >Reminders</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <a data-type="chapter-link" href="routes.html"><span class="icon ion-ios-git-branch"></span>Routes</a>
                        </li>
                    <li class="chapter">
                        <a data-type="chapter-link" href="coverage.html"><span class="icon ion-ios-stats"></span>Documentation coverage</a>
                    </li>
                    <li class="divider"></li>
                    <li class="copyright">
                        Documentation generated using <a href="https://compodoc.app/" target="_blank" rel="noopener noreferrer">
                            <img data-src="images/compodoc-vectorise.png" class="img-responsive" data-type="compodoc-logo">
                        </a>
                    </li>
            </ul>
        </nav>
        `);
        this.innerHTML = tp.strings;
    }
});