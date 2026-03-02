import {Injectable} from '@angular/core';
import {Subject} from "rxjs";

interface SubMenuItemInfo {
    name: string,
    routerLink: string
}

export interface SubMenuItem {
    infos: SubMenuItemInfo,
    subMenu: SubMenuItem[] | null,
}

const SUB_MENUS = 12;

@Injectable({
    providedIn: 'root'
})
export class SideBarService {
    showSidebar = true;
    isSmallScreen = false;

    activeSubMenu$ = new Subject<{ menu: SubMenuItem[]; refresh: boolean }>();
    subMenus: SubMenuItem[][] = [];

    constructor() {
        // Prepare submenus dynamically
        for (let i = 1; i <= SUB_MENUS; i++) {
            this.subMenus[i] = this.createSubMenu(i);
        }
    }


    setActiveSubMenu(index: number, refresh: boolean) {
        this.activeSubMenu$.next({
            menu: this.subMenus[index],
            refresh: refresh
        })
    }

    private createSubMenu(index: number): SubMenuItem[] {
        switch (index) {
            case 1:
                return [{
                    infos: {
                        name: 'Personal Details', routerLink: "/features/core/user-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Employment', routerLink: "/features/core/user-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Assets', routerLink: "/features/core/user-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Timeoff', routerLink: "/features/core/user-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Learning', routerLink: "features/core/user-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Config', routerLink: "/features/core/user-management"
                    }, subMenu: null
                }];

            case 2:
                return [{
                    infos: {
                        name: 'Dashboard', routerLink: "/features/core/user-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'SIDE_MENU.ADMIN-OPTIONS.USER', routerLink: "/features/core/user-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'SIDE_MENU.ADMIN-OPTIONS.COMPANY', routerLink: "/features/core/company-management"
                    }, subMenu: [{
                        infos: {
                            name: 'SIDE_MENU.ADMIN-OPTIONS.EMPLOYEE', routerLink: "/features/core/employee-management"
                        }, subMenu: null
                    }, {
                        infos: {
                            name: 'SIDE_MENU.ADMIN-OPTIONS.DEPARTMENT',
                            routerLink: "/features/core/department-management"
                        }, subMenu: null
                    }, {
                        infos: {
                            name: 'SIDE_MENU.ADMIN-OPTIONS.GROUP', routerLink: "/features/core/group-management"
                        }, subMenu: null
                    }, {
                        infos: {
                            name: 'Offices/Sites', routerLink: "/features/core/group-management"
                        }, subMenu: null
                    }, {
                        infos: {
                            name: 'Tasks', routerLink: "/features/core/task-management"
                        }, subMenu: null
                    }
                    ]
                }, {
                    infos: {
                        name: 'License Management', routerLink: "/features/core/department-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Roles', routerLink: "/features/core/group-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Security', routerLink: "/features/core/properties-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Billing', routerLink: "/features/core/task-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Apps', routerLink: "/features/core/user-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Countries', routerLink: "/features/core/country-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Cities', routerLink: "/features/core/city-management"
                    }, subMenu: null
                }, {
                    infos: {
                        name: 'Zipcodes', routerLink: "/features/core/zipcode-management"
                    }, subMenu: null
                }]
            case 3:
                return [{
                    infos: {
                        name: 'company', routerLink: "/features/core/user-management"
                    }, subMenu: [
                        {
                            infos: {
                                name: 'information',
                                routerLink: "/features/core/user-management"
                            }, subMenu: null
                        }, {
                            infos: {
                                name: 'org chart',
                                routerLink: "/features/core/vieworganizationChart"
                            }, subMenu: null
                        }, {
                            infos: {
                                name: 'Departments',
                                routerLink: "/features/core/user-management"
                            }, subMenu: null
                        }, {
                            infos: {
                                name: 'Office/sites',
                                routerLink: "/features/core/user-management"
                            }, subMenu: null
                        }, {
                            infos: {
                                name: 'Contacts',
                                routerLink: "/features/core/user-management"
                            }, subMenu: null
                        }
                    ]
                },
                    {
                        infos: {
                            name: 'Employees', routerLink: "/features/core/user-management"
                        }, subMenu: [
                            {
                                infos: {
                                    name: 'All Employees',
                                    routerLink: "/features/core/employee-management"
                                }, subMenu: null
                            }, {
                                infos: {
                                    name: 'Teams/Groups',
                                    routerLink: "/features/core/user-management"
                                }, subMenu: null
                            },
                        ]
                    },
                    {
                        infos: {
                            name: 'Config', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }];
            case 4:
                return [{
                    infos: {
                        name: 'Company Documents', routerLink: "/features/core/user-management"
                    }, subMenu: null
                },
                    {
                        infos: {
                            name: 'My Documents', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Config', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }];
            case 5:
                return [{
                    infos: {
                        name: 'TimeSheet', routerLink: "/features/core/user-management"
                    }, subMenu: [
                        {
                            infos: {
                                name: 'My Timesheet',
                                routerLink: "/features/time/timesheet"
                            }, subMenu: null
                        }, {
                            infos: {
                                name: 'Team timesheet',
                                routerLink: "/features/core/user-management"
                            }, subMenu: null
                        }, {
                            infos: {
                                name: 'All timesheets',
                                routerLink: "/features/core/user-management"
                            }, subMenu: null
                        }
                    ]
                },
                    {
                        infos: {
                            name: 'Time Tracker', routerLink: "/features/core/user-management"
                        }, subMenu: [
                            {
                                infos: {
                                    name: 'My Time Tracker',
                                    routerLink: "/features/core/user-management"
                                }, subMenu: null
                            }, {
                                infos: {
                                    name: 'Team Time Tracker',
                                    routerLink: "/features/core/user-management"
                                }, subMenu: null
                            }, {
                                infos: {
                                    name: 'All Time Tracker',
                                    routerLink: "/features/core/user-management"
                                }, subMenu: null
                            }
                        ]
                    },
                    {
                        infos: {
                            name: 'Overtime', routerLink: "/features/core/user-management"
                        }, subMenu: [
                            {
                                infos: {
                                    name: 'My Overtime',
                                    routerLink: "/features/core/user-management"
                                }, subMenu: null
                            }, {
                                infos: {
                                    name: 'Team overtime',
                                    routerLink: "/features/core/user-management"
                                }, subMenu: null
                            }, {
                                infos: {
                                    name: 'All overtime',
                                    routerLink: "/features/core/user-management"
                                }, subMenu: null
                            }
                        ]
                    },
                    {
                        infos: {
                            name: 'Shift plan', routerLink: "/features/core/user-management"
                        }, subMenu: [
                            {
                                infos: {
                                    name: 'My shift plan',
                                    routerLink: "/features/core/user-management"
                                }, subMenu: null
                            }, {
                                infos: {
                                    name: 'Team shift plan',
                                    routerLink: "/features/core/user-management"
                                }, subMenu: null
                            }
                        ]
                    },
                    {
                        infos: {
                            name: 'Calender', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Time Reports', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Config', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }];

            case 6:
                return [{
                    infos: {
                        name: 'Overview', routerLink: "/features/core/user-management"
                    }, subMenu: null
                },
                    {
                        infos: {
                            name: 'Allowance', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Approvals', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Requests', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Absence Reports', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Config', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }];

            case 7:
                return [{
                    infos: {
                        name: 'Expenses', routerLink: "/features/core/user-management"
                    }, subMenu: null
                },
                    {
                        infos: {
                            name: 'Budgets', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Procurements', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Invoices', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Config',
                            routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }];
            case 8:
                return [{
                    infos: {
                        name: 'Hire/Jobs', routerLink: "/features/talent/joboffer-management"
                    }, subMenu: null
                },
                    
                    {
                        infos: {
                            name: 'Applicants', routerLink: "/features/talent/jobdemande-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Resumes', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Interviews', routerLink: "/features/talent/interview-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'on/Off-boarding',
                            routerLink: "/features/core/user-management"
                        }, subMenu: [{
                            infos: {
                                name: 'OnBoarding',
                                routerLink: "/features/core/user-management"
                            }, subMenu: null
                        }, {
                            infos: {
                                name: 'OffBoarding',
                                routerLink: "/features/core/user-management"
                            }, subMenu: null
                        },]
                    },
                    {
                        infos: {
                            name: 'Talent Analytics', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Config', routerLink: "/features/core/user-management"
                        }, subMenu: [
                            {
                                infos: {
                                    name: 'Linkedin Configuration',
                                    routerLink: "/features/talent/linkedinconfig-management"
                                }, subMenu: null
                            },
                            {
                                infos: {
                                    name: 'Survey Questions',
                                    routerLink: "/features/talent/questions-management"
                                }, subMenu: null
                            } ,{
                                infos: {
                                    name: 'Talent Survey',
                                    routerLink: "/features/talent/survey-management"
                                }, subMenu: null
                            }]
                    }];
            case 9:
                return [{
                    infos: {
                        name: 'Office Management', routerLink: "/features/core/user-management"
                    }, subMenu: null
                },
                    {
                        infos: {
                            name: 'Event Management', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Resource Allocation', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Serves', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Equipment Management',
                            routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Activity Analytics',
                            routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Config',
                            routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }];

            case 10:
                return [{
                    infos: {
                        name: 'Book', routerLink: "/features/core/user-management"
                    }, subMenu: [{
                        infos: {
                            name: 'Desk booking', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }, {
                        infos: {
                            name: 'Room booking', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }
                    ]
                },
                    {
                        infos: {
                            name: 'Bookings', routerLink: "/features/core/user-management"
                        }, subMenu: [{
                            infos: {
                                name: 'My Bookings', routerLink: "/features/core/user-management"
                            }, subMenu: null
                        }, {
                            infos: {
                                name: 'Other Bookings', routerLink: "/features/core/user-management"
                            }, subMenu: null
                        }
                        ]
                    },
                    {
                        infos: {
                            name: 'Sites & workplace', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Booking Analytics', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Config & Admins',
                            routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }];

            case 11:
                return [{
                    infos: {
                        name: 'Salaries', routerLink: "/features/core/user-management"
                    }, subMenu: null
                },
                    {
                        infos: {
                            name: 'Payslips', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Payroll items', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Config', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }];
            case 12:
                return [{
                    infos: {
                        name: 'Performance Indicator', routerLink: "/features/core/user-management"
                    }, subMenu: null
                },
                    {
                        infos: {
                            name: 'Performance Review', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Performance Approval', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Goals', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Trainings', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    },
                    {
                        infos: {
                            name: 'Promotions', routerLink: "/features/core/user-management"
                        }, subMenu: null
                    }];
            default:
                return [];
        }
    }

}
